CLASSES =  Hbl.class

hbl.jj : hbl.jjt
	jjtree hbl.jjt

Hbl.java : hbl.jj
		javacc hbl.jj

Hbl.class : Hbl.java
		javac Hbl.java

HblConstants.class : HblConstants.java
		javac HblConstants.java

HblTokenManager.class : HblTokenManager.java
		javac HblTokenManager.java

ParseException.class : ParseException.java
		javac ParseException.java

SimpleCharStream.class : SimpleCharStream.java
		javac SimpleCharStream.java

Token.class : Token.java
		javac Token.java

TokenMgrError.class : TokenMgrError.java
		javac TokenMgrError.java

test : Hbl.class HblConstants.class HblTokenManager.class ParseException.class SimpleCharStream.class Token.class TokenMgrError.class
	java Hbl < test.hbl

clean :
	rm -f Hbl.java
	rm -f HblConstants.java
	rm -f HblTokenManager.java
	rm -f ParseException.java
	rm -f SimpleCharStream.java
	rm -f Token.java
	rm -f TokenMgrError.java
	rm -f *.class
	rm -f *.jj
