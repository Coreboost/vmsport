/* Generated By:JJTree: Do not edit this line. ASTInclude.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package se.atg.tabs.hblcompiler;
import javax.json.*;
public
class ASTInclude extends SimpleNode {
  private String path;

  public ASTInclude(int id) {
    super(id);
  }

  public ASTInclude(Hbl p, int id) {
    super(p, id);
  }

  public void setPath(String p) {
    path = p;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("path", path);
  }

}
/* JavaCC - OriginalChecksum=32403d5f9d2e3a502fa63c15a45b8881 (do not edit this line) */
