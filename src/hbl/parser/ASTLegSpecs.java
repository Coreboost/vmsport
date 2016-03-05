/* Generated By:JJTree: Do not edit this line. ASTLegSpecs.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
public
class ASTLegSpecs extends SimpleNode {
  public ASTLegSpecs(int id) {
    super(id);
  }

  public ASTLegSpecs(Hbl p, int id) {
    super(p, id);
  }

  public List<ASTLegSpec> getLegSpecs() {
    ArrayList<ASTLegSpec> legSpecs = new ArrayList<ASTLegSpec>();
    if (children != null) {
      Arrays.stream(children).
      filter(
        (c) -> { return c instanceof ASTLegSpec; }
      ).forEach((ls) -> {
        legSpecs.add((ASTLegSpec)ls);
      });
    }
    return legSpecs;
  }

  public Boolean legExists(Integer legNo) {
    return getLegSpecs().stream().anyMatch((l) -> {
      return l.getLeg()==legNo;
    });
  }

}
/* JavaCC - OriginalChecksum=ce7f760726cdf209f365cd3b65014cfb (do not edit this line) */
