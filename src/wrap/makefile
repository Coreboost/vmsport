all:
	@make -C clib
	@make -C flib
	@make -C c

clean:
	@make -C flib clean
	@make -C clib clean
	@make -C c clean

test: all
	@make -C c test
