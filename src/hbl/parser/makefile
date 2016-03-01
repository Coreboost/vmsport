CLP   = ./javax.json-api-1.0.jar:./javax.json-1.0.4.jar:./

AST_J = ASTAccounts.java ASTAccountSpec.java ASTDDSpec.java ASTHorses.java \
				ASTHorseSpec.java ASTInclude.java ASTLegList.java ASTLegSpec.java \
				ASTMeeting.java ASTStart.java ASTTracks.java ASTTrackSpec.java \
				ASTV75Spec.java ASTDate.java ASTLegSpecs.java ASTName.java \
				ASTPoolSpecs.java ASTStartList.java SimpleNode.java

JCC_J = Token.java TokenMgrError.java SimpleCharStream.java ParseException.java

HBL_J = Hbl.java HblConstants.java HblTokenManager.java HblTreeConstants.java

AST_C = ASTAccounts.class ASTAccountSpec.class ASTDDSpec.class ASTHorses.class \
				ASTHorseSpec.class ASTInclude.class ASTLegList.class ASTLegSpec.class \
				ASTMeeting.class ASTStart.class ASTTracks.class ASTTrackSpec.class \
				ASTV75Spec.class ASTDate.class ASTLegSpecs.class ASTName.class \
				ASTPoolSpecs.class ASTStartList.class SimpleNode.class

JCC_C = Token.class TokenMgrError.class SimpleCharStream.class ParseException.class

HBL_C = Hbl.class HblConstants.class HblTokenManager.class HblTreeConstants.class

Hbl.jj : Hbl.jjt
	jjtree Hbl.jjt
	javacc Hbl.jj

%.class : %.java Hbl.jj
		javac -classpath $(CLP) $<

test : $(AST_C) $(JCC_C) $(HBL_C)
	java -classpath $(CLP) Hbl < test.hbl

clean :
	rm -f *.class
	rm -f *.jj
