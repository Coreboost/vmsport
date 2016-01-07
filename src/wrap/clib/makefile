../lib/libmyc.a: add_ref.o
	ar rcs ../lib/libmyc.a add_ref.o

add.o: add.c
	cc -c add.c -o add.o

add_ref.o: add_ref.c
	cc -c add_ref.c -o add_ref.o

clean:
	@rm -f *.o
	@rm -f ../lib/libmyc.a
