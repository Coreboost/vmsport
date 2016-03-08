/* Generated By:JJTree: Do not edit this line. ASTLegResult.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package se.atg.tabs.hblcompiler;

import javax.json.*;
import java.util.Arrays;
public
class ASTLegResult extends SimpleNode {
  private Integer leg;
  public ASTLegResult(int id) {
    super(id);
  }

  public ASTLegResult(Hbl p, int id) {
    super(p, id);
  }

  public void setLeg(Integer l) {
    leg = l;
  }

  public ASTResultList getResultList() {
    return (ASTResultList) getChild(c -> c instanceof ASTResultList);
  }

  public void validate(ASTProgram program) {
    ASTResultList resultList = getResultList();
    if (resultList != null) {
      resultList.getResults().forEach(inPlace -> {
        inPlace.forEach(finishNo -> {
          if (!program.getLeg(leg).isValidFinisher(finishNo)) {
            ParseException.setSemanticError(finishNo + " is not a valid finisher for leg " + leg + "." );
            parser.error(parser.generateParseException().getMessage());
          }
        });
      });
    }
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("leg", leg);
  }
}
/* JavaCC - OriginalChecksum=cf681f52b0a2cb983a58fe21e8f03915 (do not edit this line) */
