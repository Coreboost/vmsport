/* Generated By:JJTree: Do not edit this line. ASTLegSpec.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.Arrays;
import javax.json.*;
public
class ASTLegSpec extends SimpleNode {
  private Integer leg;
  public ASTLegSpec(int id) {
    super(id);
  }

  public ASTLegSpec(Hbl p, int id) {
    super(p, id);
  }

  public void setLeg(Integer l) {
    leg = l;
  }

  public Integer getLeg()
  {
    return leg;
  }

  public ASTStartList getStartList() {
    return (ASTStartList)Arrays.stream(children).filter((c) -> {
      return c instanceof ASTStartList;
    }).findFirst().get();
  }

  public Boolean isValidStartNumber(Integer no) {
    return getStartList().isValidStartNumber(no);
  }

  public Boolean isValidFinisher(Integer no) {
    return getStartList().isValidFinisher(no);
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("leg", leg);
  }

}
/* JavaCC - OriginalChecksum=cd01ac894fd7a6ee7ec9c7dd5dccca69 (do not edit this line) */
