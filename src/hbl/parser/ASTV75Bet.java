/* Generated By:JJTree: Do not edit this line. ASTV75Bet.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
public
class ASTV75Bet extends AbstractBet {

  public ASTV75Bet(int id) {
    super(id);
  }

  public ASTV75Bet(Hbl p, int id) {
    super(p, id);
  }

  public AbstractPoolSpec getPoolSpec(ASTProgram program) {
    return program.
              getPoolSpecs().
              stream().
              filter((ps) -> {return ps instanceof ASTV75Spec;}).
              findAny().
              get();
  }
}
/* JavaCC - OriginalChecksum=fe53fa5da73ef54c6f94e0a3224ac7a9 (do not edit this line) */
