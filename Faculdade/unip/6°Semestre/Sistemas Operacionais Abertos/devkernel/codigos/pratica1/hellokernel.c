/**
 * Universidade de Sao Paulo - USP Sao Carlos
 * 15a. SEMCOMP - ICMC/USP
 *
 * Minicurso: Desvendando o kernel do Linux
 * Autor: Renê de Souza Pinto
 *
 * hellokernel.c: Esqueleto de um módulo do kernel
 */

#include <linux/module.h>
#include <linux/init.h>

/** inicializar modulo */
static int __init hellokernel_init(void)
{
	printk(KERN_ALERT "%s: Ola Mundo do kernel!\n", THIS_MODULE->name);
	return(0);
}

/** cleanup */
static void __exit hellokernel_exit(void)
{
	printk(KERN_ALERT "%s: Adeus do kernel!\n", THIS_MODULE->name);
}

module_init(hellokernel_init);
module_exit(hellokernel_exit);
MODULE_AUTHOR("Fulano da Silva");
MODULE_DESCRIPTION("Meu primeiro modulo para o kernel");
MODULE_LICENSE("GPL");

