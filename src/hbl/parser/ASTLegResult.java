/* Generated By:JJTree: Do not edit this line. ASTLegResult.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
public
class ASTLegResult extends SimpleNode {
  private Integer leg;
  public ASTLegResult(int id) {
    super(id);
  }

  public ASTLegResult(Hbl p, int id) {
    super(p, id);
  }

  public void setLeg(Integer l) {
    leg = l;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("leg", leg);
  }
}
/* JavaCC - OriginalChecksum=cf681f52b0a2cb983a58fe21e8f03915 (do not edit this line) */
