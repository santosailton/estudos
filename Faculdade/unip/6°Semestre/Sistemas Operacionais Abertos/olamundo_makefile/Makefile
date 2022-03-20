##
#Meu primeiro Makefile
#
CC=gcc
CFLAGS=
LDFLAGS=

EXECUTABLE=hello
SOURCES=hello.c sayHello.c

OBJECTS=$(SOURCES:.c=.o)

.PHONY:clean

all: $(OBJECTS)
	$(CC) $(LDFLAGS) $? -o $(EXECUTABLE) 

%.o: %.c
	$(CC) $(CFLAGS) -c $<

Makefile.d: $(SOURCES)
	$(CC) -MM $? >> $@

-include Makefile.d

clean:
	@rm Makefile.d $(OBJECTS) $(EXECUTABLE) 
