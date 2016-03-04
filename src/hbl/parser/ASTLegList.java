/* Generated By:JJTree: Do not edit this line. ASTLegList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
import java.util.ArrayList;
public
class ASTLegList extends SimpleNode {
  ArrayList<Integer> legs = new ArrayList<Integer>();

  public ASTLegList(int id) {
    super(id);
  }

  public ASTLegList(Hbl p, int id) {
    super(p, id);
  }

  public void addLeg(Integer l) {
    legs.add(l);
  }

  public void validateLegs(Integer maxLegs) {
    if (legs.size() > maxLegs) {
      ParseException.setSemanticError("Too many legs, a maximum of " + maxLegs + " allowed, found " + legs.size() + ".");
      parser.error(parser.generateParseException().getMessage());
    }
    if (legs.size() > 1) {
      for (int i=1; i < legs.size(); i += 1) {
        if (!(legs.get(i)>legs.get(i-1))) {
          ParseException.setSemanticError("Leg numbers must be in increasing order.");
          parser.error(parser.generateParseException().getMessage());
        }
      }
    }
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    JsonArrayBuilder myBuilder = Json.createArrayBuilder();
    legs.forEach((leg) -> {
      myBuilder.add(leg);
    });
    builder.add("legs", myBuilder.build());
  }

}
/* JavaCC - OriginalChecksum=f6fae3fe3e12f9cdfbff2ca8b48c0389 (do not edit this line) */
