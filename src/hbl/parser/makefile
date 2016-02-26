CLP   = ./javax.json-api-1.0.jar:./javax.json-1.0.4.jar:./

AST_J = ASTAccounts.java ASTAccountSpec.java ASTDDSpec.java ASTHorses.java \
				ASTHorseSpec.java ASTInclude.java ASTLegList.java ASTLegSpec.java \
				ASTMeeting.java ASTStart.java ASTTracks.java ASTTrackSpec.java \
				ASTV75Spec.java

JJT_J = SimpleNode.java

JCC_J = Token.java TokenMgrError.java SimpleCharStream.java ParseException.java

HBL_J = Hbl.java HblConstants.java HblTokenManager.java HblTreeConstants.java

AST_C = ASTAccounts.class ASTAccountSpec.class ASTDDSpec.class ASTHorses.class \
				ASTHorseSpec.class ASTInclude.class ASTLegList.class ASTLegSpec.class \
				ASTMeeting.class ASTStart.class ASTTracks.class ASTTrackSpec.class \
				ASTV75Spec.class

JJT_C = SimpleNode.class

JCC_C = Token.class TokenMgrError.class SimpleCharStream.class ParseException.class

HBL_C = Hbl.class HblConstants.class HblTokenManager.class HblTreeConstants.class

hbl.jj : hbl.jjt $(AST_J) $(JJT_J) $(JCC_J) $(HBL_J)
	jjtree hbl.jjt
	javacc hbl.jj

%.class : %.java hbl.jj
		javac -classpath $(CLP) $<

test : $(AST_C) $(JJT_C) $(JCC_C) $(HBL_C)
	java -classpath $(CLP) Hbl < test.hbl

clean :
	rm -f *.class
	rm -f *.jj
