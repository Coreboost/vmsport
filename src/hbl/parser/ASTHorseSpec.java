/* Generated By:JJTree: Do not edit this line. ASTHorseSpec.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.HashSet;
import javax.json.*;
public
class ASTHorseSpec extends SimpleNode {
  private String name;
  private Integer rank;
  private static HashSet<ASTHorseSpec> horses = new HashSet<ASTHorseSpec>();

  public static Boolean horseExists(String name) {
    return
    horses.
      stream().
      anyMatch((h) -> name.equals(h.name));
  }

  public ASTHorseSpec(int id) {
    super(id);
    horses.add(this);
  }

  public ASTHorseSpec(Hbl p, int id) {
    super(p, id);
    horses.add(this);
  }

  public void setName(String n) {
    if (horseExists(n)) {
      ParseException.setSemanticError("A horse with name " + n + " is already defined.");
      parser.error(parser.generateParseException().getMessage());
    }
    name = n;
  }

  public void setRank(Integer r) {
    rank = r;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("name", name);
    builder.add("rank", rank);
  }
}
/* JavaCC - OriginalChecksum=ed18107cf54540aa4964dc61102f92c3 (do not edit this line) */
