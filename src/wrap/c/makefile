ftest: ftest.o ../lib/libf.a
	cc -static ftest.o -L../lib -lf -lgfortran -o ftest

lib:
	@make -C ../flib

ftest.o: ftest.c
	cc -c ftest.c -o ftest.o

test: ftest
	@./ftest

clean:
	@rm -f ftest
	@rm -f ftest.o
