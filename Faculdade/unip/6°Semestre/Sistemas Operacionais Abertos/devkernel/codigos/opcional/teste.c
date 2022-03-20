/**
 * Universidade de Sao Paulo - USP Sao Carlos
 * 15a. SEMCOMP - ICMC/USP
 *
 * Minicurso: Desvendando o kernel do Linux
 * Autor: Renê de Souza Pinto
 *
 * teste.c: Testando o novo driver implementado
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define BUFFER_LEN 20

/** comandos de controle do terminal */
#define CLEAR_SCREEN  	"\033[2J\033[0;0f"
#define CLEAR_ENDLINE 	"\033[K"
#define MOVETO(pos) 	"\033["pos"f"

/** protótipos */
void send_term(const char *command);
void endprog(int sig);

/** variáveis globais */
static int i;

/** main */
int main(int argc, const char *argv[])
{
	int fd;
	char msg[BUFFER_LEN];
	ssize_t len;

	if ((fd=open("/dev/clockseg0", O_RDONLY)) < 0) {
		perror("Erro ao abrir arquivo\n");
		return EXIT_FAILURE;
	}

	i = 0;
	signal(SIGINT, endprog);

	send_term(CLEAR_SCREEN);
	printf("Leitura: ");
	while(!i) {
		len = read(fd, msg, BUFFER_LEN);
		msg[len] = '\0';
		if (len > 0) {
			printf("%s   ", msg);
			fflush(stdout);
			send_term(MOVETO("0;11"));
			send_term(CLEAR_ENDLINE);
			lseek(fd, 0, SEEK_SET);	
		}
	}
	send_term(CLEAR_SCREEN);
	printf("\nAte logo!\n\n");

	close(fd);
	return EXIT_SUCCESS;
}

/** envia strings de comando ao terminal */
void send_term(const char *command)
{
	write(STDOUT_FILENO, command, strlen(command));
}

/** callback para Ctrl+c */
void endprog(int sig)
{
	i = 1;
}

