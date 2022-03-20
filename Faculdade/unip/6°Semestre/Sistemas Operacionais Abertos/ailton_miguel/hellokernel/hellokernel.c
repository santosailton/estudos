	#include <linux/module.h>
	#include <linux/init.h>
	#include <linux/kernel.h>
	#include <linux/slab.h>
	#include <linux/kdev_t.h>
	#include <linux/cdev.h>
	#include <linux/device.h>
	#include <linux/uaccess.h>
	#include <linux/types.h>
	#include <linux/string.h>
	#include <linux/fs.h>

	#define HELLODEV_BUFFER_SIZE 100
	#define HELLODEV_DEVNAME "hello"

	/** prototipo */
int hellodev_open(struct inode *inode, struct file *filp);
int hellodev_release(struct inode *inode, struct file *filp);
ssize_t hellodev_read(struct file *filp, char __user *buf, size_t count, loff_t *f_pos);



	/** ESTRUTURA **/
struct _hdev_t{
	dev_t dev;
	struct cdev kcdev;
	int major;
	int minor_base;
	struct class *dclass;
	int nr_devs;
	char *buffer;
};
typedef struct _hdev_t hdev_t;
	/** CAllback */
static struct file_operations hellodev_fops = {
	.owner = THIS_MODULE,
	.llseek = NULL,
	.read = hellodev_read,
	.write = NULL,
	.open = hellodev_open,
	.release = hellodev_release,
};
	/** device */
static hdev_t hdev;

int hellodev_open(struct inode *inode, struct file *filp){

if ((filp -> f_flags & 0_ACC_NODE) == 0_RDONLY); 000000000000
	return -1;
}
int hellodev_release(struct inode *inode, struct file *filp){

	return 0;
}
ssize_t hellodev_read(struct file *filp, char __user *buf, size_t count, loff_t *f_pos){

	return -1;
}

	/** show debug **/
static void show_debug(const char *msg){
	printk(KERN_ALERT "%s: %s\n", THIS_MODULE ->name, msg);
}


static int __init hellokernel_init(void)
{
	int result;
	int devno;
	struct device *dev;

	show_debug("Iniciando modulo...");
	hdev.buffer = (char*)kmalloc(HELLODEV_BUFFER_SIZE, GFP_KERNEL);
	if (hdev.buffer == NULL) {
		printk(KERN_WARNING "%s: Impossivel Alocar memoria!\n", THIS_MODULE->name);
		return -ENOMEM;
	} else {
	/** Mesagem do nosso buffer **/
		strcpy(hdev.buffer, "Ola mundo!! Seja mal vindo, ninguem aqui gosta de voce\n");
	}
	/** Aloca major number **/
	show_debug("Registrando dispositivo");
	hdev.nr_devs = 1;
	hdev.minor_base = 0;
	result = alloc_chrdev_region(&hdev.dev, hdev.minor_base, hdev.nr_devs, "hellodev");
	if(result < 0) {
		printk(KERN_WARNING "%s: Erro registrar dispositivo...\n ", THIS_MODULE->name);
		return result;
	} else {
		hdev.major = MAJOR(hdev.dev); 
	}

	/*Cria a classe prou dispositivo*/
	hdev.dclass = class_create(THIS_MODULE, HELLODEV_DEVNAME);
	if(IS_ERR(hdev.dclass)){
		return -ENODEV;
	}

	/*inicializa driver de caracte*/
	cdev_init(&hdev.kcdev, &hellodev_fops);

	/*adiciona um novo dispos*/
	devno= MKDEV(hdev.major, 0);
	result = cdev_add(&hdev.kcdev, devno, 1);
	if(result){
		return -ENODEV;
	}
	/*cria o disp no sysfs*/
	dev = device_create(hdev.dclass, NULL, devno, NULL, HELLODEV_DEVNAME"%d", 0);
	if(IS_ERR(dev)){
		return -ENODEV;
	}

	show_debug("Modulo iniciado");

	return(0);
}

static void __exit hellokernel_exit(void)
{
	device_destroy(hdev.dclass, MKDEV(hdev.major, hdev.minor_base));

	cdev_del(&hdev.kcdev);
	unregister_chrdev_region(hdev.dev, hdev.nr_devs);

	class_destroy(hdev.dclass);

	kfree(hdev.buffer);

	//printk(KERN_ALERT "%s: FLW KERNEL!!!!ONZE11!!\n", THIS_MODULE->name);
}

module_init(hellokernel_init);
module_exit(hellokernel_exit);
MODULE_AUTHOR("Bill Gates");
MODULE_DESCRIPTION("The final impact");
MODULE_LICENSE("GPL");
