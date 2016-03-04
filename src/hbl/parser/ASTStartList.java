/* Generated By:JJTree: Do not edit this line. ASTStartList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
import java.util.ArrayList;
public
class ASTStartList extends SimpleNode {
  private ArrayList<String> horses = new ArrayList<String>();

  public ASTStartList(int id) {
    super(id);
  }

  public ASTStartList(Hbl p, int id) {
    super(p, id);
  }

  public void addHorse(String h) {
    if (!ASTHorseSpec.horseExists(h)) {
      ParseException.setSemanticError("The horse " + h + " is not defined.");
      parser.error(parser.generateParseException().getMessage());
    }
    if (!horses.contains(h)) {
      horses.add(h);
    } else {
      ParseException.setSemanticError("A horse with name " + h + " is already on the start list for the leg.");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    JsonArrayBuilder myBuilder = Json.createArrayBuilder();
    horses.forEach((horse) -> {
      myBuilder.add(horse);
    });
    builder.add("horses", myBuilder.build());
  }
}
/* JavaCC - OriginalChecksum=4f5b803f8c0ff227a472baab8989a885 (do not edit this line) */
