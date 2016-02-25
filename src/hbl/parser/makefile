hbl.jj : hbl.jjt
	jjtree hbl.jjt

Hbl.java : hbl.jj
		javacc hbl.jj

Hbl.class : Hbl.java
	javac *.java

test : Hbl.class
	java Hbl < test.hbl

clean :
	rm *.java
	rm *.class
