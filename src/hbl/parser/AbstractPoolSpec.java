/* Generated By:JJTree: Do not edit this line. ASTDDBet.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.HashSet;
import javax.json.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public
class AbstractPoolSpec extends SimpleNode {
  private static HashSet<String> betIDs = new HashSet<String>();

  private String betID = null;
  private String accountID = null;
  private Integer amount = -1;
  private Boolean fortuna=false;
  private Boolean boost = false;
  private Integer multiplier = 1;
  private Integer repeatCount = 1;


  public AbstractPoolSpec(int id) {
    super(id);
  }

  public AbstractPoolSpec(Hbl p, int id) {
    super(p, id);
  }

  public ASTLegList getLegList() {
    return (ASTLegList)Arrays.stream(children).
      filter( (c) -> c instanceof ASTLegList ).
      findAny().
      get();
  }

  public List<Integer> getLegs() {
    return getLegList().getLegs();
  }

  public Integer getActualLeg(Integer poolLeg) {
    return getLegList().getActualLeg(poolLeg);
  }
}
/* JavaCC - OriginalChecksum=868050054722ee824d8adfecd6d77deb (do not edit this line) */
