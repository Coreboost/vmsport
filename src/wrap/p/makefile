F.so: ../flib/*.f
	f2py -c ../flib/*.f -m F

test:
	python interop.py

clean:
	rm -f F.so
