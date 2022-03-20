
.global _start

.equ SYS_WRITE, 0x04
.equ SYS_EXIT,  0x01
.equ STDOUT,    0x01

.text 0
_start:
	mov $SYS_WRITE,%eax
	mov $STDOUT,%ebx
	mov $msg,%ecx
	mov $0x0B,%edx
	int $0x80

	mov $SYS_EXIT,%eax
	mov $0x00,%ebx
	int $0x80

.data 0
msg:
	.ascii "Ola Mundo!\n"

