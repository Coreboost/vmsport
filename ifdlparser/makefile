translation : grammar.py minimal.ifdl
	python grammar.py form_decl minimal.ifdl
grammar.py : grammar.g df_classes.py
	python -m yapps.cli_tool grammar.g
clean :
	rm -f grammar.py
	rm -f *.pyc
