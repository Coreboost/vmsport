COMPILE_OPTIONS = -std=f95 -fsign-zero
../lib/libf.a: add.o addvector.o ispositive.o isnot.o containschar.o concat.o addfloat.o
	ar rcs ../lib/libf.a add.o addvector.o ispositive.o isnot.o containschar.o concat.o addfloat.o

add.o: add.f
	gfortran $(COMPILE_OPTIONS) -c add.f -o add.o

addfloat.o: addfloat.f
	gfortran $(COMPILE_OPTIONS) -c addfloat.f -o addfloat.o

ispositive.o: ispositive.f
	gfortran $(COMPILE_OPTIONS) -c ispositive.f -o ispositive.o

isnot.o: isnot.f
	gfortran $(COMPILE_OPTIONS) -c isnot.f -o isnot.o

addvector.o: addvector.f
	gfortran $(COMPILE_OPTIONS) -c addvector.f -o addvector.o

containschar.o: containschar.f
	gfortran $(COMPILE_OPTIONS) -c containschar.f -o containschar.o

concat.o: concat.f
		gfortran $(COMPILE_OPTIONS) -c concat.f -o concat.o

clean:
	@rm -f *.o
	@rm -f ../lib/libf.a
