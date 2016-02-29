/* Generated By:JJTree: Do not edit this line. ASTDDBet.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
public
class ASTDDBet extends SimpleNode {
  private String accountID = null;
  private String betID;
  private Integer amount;

  public ASTDDBet(int id) {
    super(id);
  }

  public ASTDDBet(Hbl p, int id) {
    super(p, id);
  }

  public void setAccountID(String id) {
    accountID = id;
  }

  public void setBetID(String id) {
    betID = id;
  }

  public void setAmount(Integer a) {
    amount = a;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("betID", betID);
    if (accountID != null) {
      builder.add("accountID", accountID);
    }
    builder.add("amount", amount);
  }
}
/* JavaCC - OriginalChecksum=868050054722ee824d8adfecd6d77deb (do not edit this line) */
