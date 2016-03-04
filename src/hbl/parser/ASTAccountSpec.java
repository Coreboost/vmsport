/* Generated By:JJTree: Do not edit this line. ASTAccountSpec.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.HashSet;
import javax.json.*;
public
class ASTAccountSpec extends SimpleNode {
  private String name;
  private Integer amount;
  private static HashSet<String> accountNames = new HashSet<String>();

  public ASTAccountSpec(int id) {
    super(id);
  }

  public ASTAccountSpec(Hbl p, int id) {
    super(p, id);
  }

  public void setName(String n) throws ParseException  {
    name = n;
    if (accountNames.contains(name)) {
      ParseException.setSemanticError("The account " + name + " is already defined.");
      throw parser.generateParseException();
    } else {
      accountNames.add(name);
    }
  }

  public void setAmount(Integer n) {
    amount = n;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("name", name);
    builder.add("amount", amount);
  }

}
/* JavaCC - OriginalChecksum=c95a325e02af29d365bd8e19d782da44 (do not edit this line) */
