##
# Makefile para módulo do kernel
# Adaptado do Livro: 
# 	Rubini, A./Corbet, J.: "Linux Device Drivers, Third Edition".
#	O'Reilly & Associates, 2001.
#

# Se a variável KERNELRELEASE está definida significa que fomos
# invocados do sistema de compilação do kernel e podemos usar
# sua linguagem
ifneq ($(KERNELRELEASE),)
		obj-m := hellokernel.o

# Senão, fomos chamados do linha de comando;
# invoque o sistema de compilação do kernel
else
	
	KERNELDIR ?= /lib/modules/$(shell uname -r)/build
	PWD := $(shell pwd)

default:
	$(MAKE) -C $(KERNELDIR) M=$(PWD) modules

clean:
	$(MAKE) -C $(KERNELDIR) M=$(PWD) clean

endif

