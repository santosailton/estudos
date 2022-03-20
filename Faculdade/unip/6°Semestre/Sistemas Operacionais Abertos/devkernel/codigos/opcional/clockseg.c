/**
 * Universidade de Sao Paulo - USP Sao Carlos
 * 15a. SEMCOMP - ICMC/USP
 *
 * Minicurso: Desvendando o kernel do Linux
 * Autor: Renê de Souza Pinto
 *
 * clockseg.c: Um módulo simples que implementa um relogio
 */

#include <linux/module.h>
#include <linux/init.h>
#include <linux/slab.h>
#include <linux/fs.h>
#include <linux/types.h>
#include <linux/kdev_t.h>
#include <linux/cdev.h>
#include <linux/device.h>
#include <asm/uaccess.h>
#include <linux/string.h>
#include <linux/jiffies.h>
#include <linux/timer.h>

#define CLKSEG_BUFFER_SIZE 10
#define CLKSEG_DEVNAME "clockseg"

/** prototipos */
static void show_debug(const char *msg);
int clkseg_open(struct inode *inode, struct file *filp);
int clkseg_release(struct inode *inode, struct file *filp);
ssize_t clkseg_read(struct file *filp, char __user * buf, size_t count,
		    loff_t * f_pos);
loff_t clkseg_llseek(struct file *filp, loff_t offset, int whence);

/***/
static struct _clkdev_t {
	dev_t dev;
	struct cdev kcdev;
	int major;
	int minor;		/* = 0; */
	struct class *dclass;
	int nr_devs;
	int tdelay;
	struct timer_list timer;
	char *buffer;
	int b_pos;
} clkdev;

static struct file_operations clkseg_fops = {
	.owner = THIS_MODULE,
	.llseek = clkseg_llseek,
	.read = clkseg_read,
	.write = NULL,
	.open = clkseg_open,
	.release = clkseg_release,
};

static int debug;		/* = 0; */

/**
 * update_clk: atualiza relogio
 */
void update_clk(unsigned long arg)
{
	int segs = jiffies / clkdev.tdelay;

	sprintf(clkdev.buffer, "%d", segs);

	clkdev.timer.expires = jiffies + clkdev.tdelay;
	add_timer(&clkdev.timer);
}

/**
 * open: abre dispositivo
 */
int clkseg_open(struct inode *inode, struct file *filp)
{
	struct _clkdev_t *dev;

	dev = container_of(inode->i_cdev, struct _clkdev_t, kcdev);
	filp->private_data = dev;

	/** checa metodo de abertura */
	if ((filp->f_flags & O_ACCMODE) == O_RDONLY) {
		return 0;
	} else {
		return -EPERM;
	}
}

/**
 * release: fecha o dispositivo
 */
int clkseg_release(struct inode *inode, struct file *filp)
{
	return 0;
}

/**
 * read: envia buffer para usuário
 */
ssize_t clkseg_read(struct file * filp, char __user * buf, size_t count,
		    loff_t * f_pos)
{
	ssize_t blen, res;

	blen = strlen(clkdev.buffer);
	if (*f_pos < blen) {
		if (*f_pos + count > blen) {
			res = blen - *f_pos;
		} else {
			res = count;
		}

		if (copy_to_user(buf, clkdev.buffer + *f_pos, res)) {
			return -EFAULT;
		} else {
			*f_pos += res;
			return res;
		}
	} else {
		return 0;
	}
}

/**
 * llseek: muda posição no buffer
 */
loff_t clkseg_llseek(struct file * filp, loff_t offset, int whence)
{
	ssize_t blen = strlen(clkdev.buffer);
	switch (whence) {
	case SEEK_SET:
		if (offset < blen) {
			filp->f_pos = offset;
		} else {
			filp->f_pos = blen;
		}
		break;

	case SEEK_CUR:
		if (filp->f_pos + offset < blen) {
			filp->f_pos += offset;
		} else {
			filp->f_pos = blen;
		}
		break;

	case SEEK_END:
		if (blen - offset >= 0) {
			filp->f_pos = blen - offset;
		} else {
			filp->f_pos = 0;
		}
		break;

	default:
		return -EINVAL;
	}

	return (filp->f_pos);
}

/** debug **/
static void show_debug(const char *msg)
{
	if (debug)
		printk(KERN_DEBUG "%s: %s\n", THIS_MODULE->name, msg);
}

/** inicializa modulo */
static int __init clkseg_init(void)
{
	int result;
	int devno;
	struct device *dev;

	show_debug("Inicializando modulo");

	/** Primeiro tenta alocar buffer */
	clkdev.buffer = kmalloc(CLKSEG_BUFFER_SIZE, GFP_KERNEL);
	if (clkdev.buffer == NULL) {
		printk(KERN_WARNING "%s: Impossivel alocar memoria!",
		       THIS_MODULE->name);
		return (-ENOMEM);
	} else {
		strcpy(clkdev.buffer, "0\n");

		clkdev.tdelay = 1 * HZ;	/* 1 segundo */
		clkdev.b_pos = 0;

		init_timer(&clkdev.timer);
		clkdev.timer.expires = jiffies + clkdev.tdelay;
		clkdev.timer.function = update_clk;
		add_timer(&clkdev.timer);
	}

	/** Aloca major number para o dispositivo */
	clkdev.nr_devs = 1;
	result =
	    alloc_chrdev_region(&clkdev.dev, clkdev.minor, clkdev.nr_devs,
				"clockseg");
	if (result < 0) {
		printk(KERN_WARNING
		       "%s: Nao foi possivel alocar major number!\n",
		       THIS_MODULE->name);
		return (result);
	} else {
		clkdev.major = MAJOR(clkdev.dev);
	}

	/** Cria a classe para o dispositivo */
	clkdev.dclass = class_create(THIS_MODULE, CLKSEG_DEVNAME);
	if (IS_ERR(clkdev.dclass)) {
		unregister_chrdev_region(clkdev.dev, clkdev.nr_devs);
		return (-ENODEV);
	}

	/** Inicia disposivo de caractere */
	cdev_init(&clkdev.kcdev, &clkseg_fops);
	clkdev.kcdev.owner = THIS_MODULE;
	clkdev.kcdev.ops = &clkseg_fops;

	devno = MKDEV(clkdev.major, 0);
	result = cdev_add(&clkdev.kcdev, devno, 1);
	if (result) {
		printk(KERN_WARNING "%s: Erro ao adicionar dispositivo",
		       THIS_MODULE->name);
		unregister_chrdev_region(clkdev.dev, clkdev.nr_devs);
		class_destroy(clkdev.dclass);
		return (-ENODEV);
	}

	dev = device_create(clkdev.dclass, NULL, devno, NULL, CLKSEG_DEVNAME "%d", 0);
	if (IS_ERR(dev)) {
		unregister_chrdev_region(clkdev.dev, clkdev.nr_devs);
		class_destroy(clkdev.dclass);
		cdev_del(&clkdev.kcdev);
		return (-ENODEV);
	}

	show_debug("Modulo iniciado");

	return (0);
}

/** cleanup */
static void __exit clkseg_exit(void)
{
	show_debug("Descarregando modulo");

	del_timer(&clkdev.timer);
	kfree(clkdev.buffer);

	device_destroy(clkdev.dclass, MKDEV(clkdev.major, clkdev.minor));
	
	cdev_del(&clkdev.kcdev);
	unregister_chrdev_region(clkdev.dev, clkdev.nr_devs);

	class_destroy(clkdev.dclass);

	show_debug("Modulo descarregado");
}

module_init(clkseg_init);
module_exit(clkseg_exit);
module_param(debug, bool, S_IRUGO);
MODULE_AUTHOR("Rene de Souza Pinto");
MODULE_DESCRIPTION("Um simples relogio para o kernel");
MODULE_LICENSE("GPL");
