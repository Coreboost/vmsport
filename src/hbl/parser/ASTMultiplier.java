/* Generated By:JJTree: Do not edit this line. ASTMultiplier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTMultiplier extends SimpleNode {
  private Integer value = 1;
  public ASTMultiplier(int id) {
    super(id);
  }

  public ASTMultiplier(Hbl p, int id) {
    super(p, id);
  }

  public void setValue(Integer v) {
    value = v;
  }

  public Integer getValue() {
    return value;
  }

  public Boolean skipNode() {
    return true;
  }
}
/* JavaCC - OriginalChecksum=c86625b9733504fc9aedfe86e11e554a (do not edit this line) */