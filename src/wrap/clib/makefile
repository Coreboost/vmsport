../lib/libc.a: add.o
	ar rcs ../lib/libc.a add.o

add.o: add.c
	cc -c add.c -o add.o

clean:
	@rm -f *.o
	@rm -f ../lib/libc.a
