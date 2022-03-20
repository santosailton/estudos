#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, const char *argv[]){
	int fp;
	char *msg = "Ola Mundo\n";

	if((fp = open("ola.txt", O_WRONLY | O_CREAT, S_IWUSR | S_IRUSR)) < 0){
		fprintf(stderr, "Impossivel abrir arquivor.\n");
		return EXIT_FAILURE;
	}
	write(fp, msg, strlen(msg));

	close(fp);
	return EXIT_SUCCESS;
}
