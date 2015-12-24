translation : grammar.py test.ifdl
	python grammar.py form_declaration test.ifdl
grammar.py : grammar.g df_classes.py
	python -m yapps.cli_tool grammar.g
clean :
	rm -f grammar.py
	rm -f *.pyc
