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

  public void validate() {
    List<ASTLegSpec> legSpecs = getLegSpecs();
    if (legSpecs.size() != 0) {
      if (!(legSpecs.get(0).getLeg() == 1)) {
        ParseException.setSemanticError("Leg numbering must start at 1.");
        parser.error(parser.generateParseException().getMessage());
      }
      if (legSpecs.size() > 1) {
        for (int i=1; i < legSpecs.size(); i += 1) {
          if (!(legSpecs.get(i).getLeg() == (legSpecs.get(i-1).getLeg() + 1))) {
            ParseException.setSemanticError("Legs must be specfied in consecutive order.");
            parser.error(parser.generateParseException().getMessage());
          }
        }
      }
    }
  }

}
/* JavaCC - OriginalChecksum=ce7f760726cdf209f365cd3b65014cfb (do not edit this line) */
