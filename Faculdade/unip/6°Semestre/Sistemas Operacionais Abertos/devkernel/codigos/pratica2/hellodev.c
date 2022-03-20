/**
 * Copyright (C) 2010 Renê de Souza Pinto
 *
 * Este programa é software livre; você pode redistribuí-lo e/ou
 * modificá-lo sob os termos da Licença Pública Geral GNU, conforme
 * publicada pela Free Software Foundation; tanto a versão 2 da
 * Licença como (a seu critério) qualquer versão mais nova.
 * 
 * Este programa é distribuído na expectativa de ser útil, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia implícita de
 * COMERCIALIZAÇÃO ou de ADEQUAÇÃO A QUALQUER PROPÓSITO EM
 * PARTICULAR. Consulte a Licença Pública Geral GNU para obter mais
 * detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa; se não, escreva para a Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307, USA.
 */

/**
 * Exemplo de um módulo para um dispositivo que pode ser lido
 * retornando um buffer de caracteres.
 */

#include <linux/module.h>
#include <linux/init.h>
#include <linux/kernel.h>
#include <linux/slab.h>
#include <linux/kdev_t.h>
#include <linux/cdev.h>
#include <linux/device.h>
#include <asm/uaccess.h>
#include <linux/types.h>
#include <linux/string.h>
#include <linux/fs.h>

#define HELLODEV_BUFFER_SIZE 100
#define HELLODEV_DEVNAME "hello"

/** prototipos */
int hellodev_open(struct inode *inode, struct file *filp);
int hellodev_release(struct inode *inode, struct file *filp);
ssize_t hellodev_read(struct file *filp, char __user *buf, size_t count, loff_t *f_pos);


/**
 * Estrutura interna (para uso do módulo) do nosso dispositivo
 */
struct _hdev_t {
	dev_t dev;
	struct cdev kcdev;
	int major;
	int minor_base;
	struct class *dclass;
	int nr_devs;
	char *buffer;
};

typedef struct _hdev_t hdev_t;


/**
 * Callbacks do nosso dispositivo
 */
static struct file_operations hellodev_fops = {
	.owner = THIS_MODULE,
	.llseek = NULL,
	.read = hellodev_read,
	.write = NULL,
	.open = hellodev_open,
	.release = hellodev_release,
};

/** dev */
static hdev_t hdev;


/** open */
int hellodev_open(struct inode *inode, struct file *filp)
{
	/*struct _hdev_t *dev;
	dev = container_of(inode->i_cdev, struct _hdev_t, kcdev);
	filp->private_data = dev;*/

	if ((filp->f_flags & O_ACCMODE) == O_RDONLY) {
		return 0;
	} else {
		return -EPERM;
	}
}

/** close */
int hellodev_release(struct inode *inode, struct file *filp)
{
	return 0;
}

/** read */
ssize_t hellodev_read(struct file *filp, char __user *buf, size_t count, loff_t *f_pos)
{
	ssize_t blen, cnt;

	blen = strlen(hdev.buffer);
	if (*f_pos < blen) {
		if (*f_pos + count > blen) {
			cnt = blen - *f_pos;
		} else {
			cnt = count;
		}

		if (copy_to_user(buf, hdev.buffer + *f_pos, cnt)) {
			return -EFAULT;
		} else {
			*f_pos += cnt;
			return cnt;
		}
	} else {
		return 0;
	}
}


/** show_debug */
static void show_debug(const char *msg)
{
	printk(KERN_ALERT "%s: %s\n", THIS_MODULE->name, msg);
}

/** init */
static int __init hellodev_init(void)
{	
	int result;
	int devno;
	struct device *dev;

	show_debug("Iniciando modulo");
	
	hdev.buffer = (char*)kmalloc(HELLODEV_BUFFER_SIZE, GFP_KERNEL);
	if (hdev.buffer == NULL) {
		printk(KERN_WARNING "%s: Impossivel alocar memoria!\n", THIS_MODULE->name);
		return -ENOMEM;
	} else {
		/**
		 * Mensagem do nosso buffer
		 */
		strcpy(hdev.buffer, "Ola Mundo! Seja Bem vindo ao kernel do Linux!\n");
	}

	/** Aloca major number para o dispositivo */
	show_debug("Registrando dispositivo");
	hdev.nr_devs = 1;
	hdev.minor_base = 0;
	result = alloc_chrdev_region(&hdev.dev, hdev.minor_base, hdev.nr_devs, "hellodev");
	if (result < 0) {
		printk(KERN_WARNING "%s: Nao foi possivel registrar o dispositivo\n", THIS_MODULE->name);
		return result;
	} else {
		hdev.major = MAJOR(hdev.dev);
	}

	/** Cria a classe para o dispositivo */
	hdev.dclass = class_create(THIS_MODULE, HELLODEV_DEVNAME);
	if (IS_ERR(hdev.dclass)) {
		unregister_chrdev_region(hdev.dev, hdev.nr_devs);
		return (-ENODEV);
	}

	/** iniciar o dispositivo de caracter */
	cdev_init(&hdev.kcdev, &hellodev_fops);
	hdev.kcdev.owner = THIS_MODULE;
	hdev.kcdev.ops = &hellodev_fops;

	devno = MKDEV(hdev.major, 0);
	result = cdev_add(&hdev.kcdev, devno, 1);
	if (result) {
		printk(KERN_WARNING "%s: Erro ao adicionar dispositivo\n", THIS_MODULE->name);
		unregister_chrdev_region(hdev.dev, hdev.nr_devs);
		class_destroy(hdev.dclass);
		return -ENODEV;
	}

	dev = device_create(hdev.dclass, NULL, devno, NULL, HELLODEV_DEVNAME"%d", 0);
	if (IS_ERR(dev)) {
		unregister_chrdev_region(hdev.dev, hdev.nr_devs);
		cdev_del(&hdev.kcdev);
		class_destroy(hdev.dclass);
		return (-ENODEV);
	}

	show_debug("modulo iniciado");
	return 0;
}

/** exit */
static void __exit hellodev_exit(void)
{
	show_debug("descarregando modulo");

	kfree(hdev.buffer);

	device_destroy(hdev.dclass, MKDEV(hdev.major, hdev.minor_base));

	cdev_del(&hdev.kcdev);
	unregister_chrdev_region(hdev.dev, hdev.nr_devs);

	class_destroy(hdev.dclass);

	show_debug("modulo descarregado");
}

module_init(hellodev_init);
module_exit(hellodev_exit);
MODULE_AUTHOR("Rene de Souza Pinto");
MODULE_DESCRIPTION("Um pequeno dispositivo de caracter");
MODULE_LICENSE("GPL");

