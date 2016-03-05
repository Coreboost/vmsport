/* Generated By:JJTree: Do not edit this line. ASTDDBet.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
import java.util.List;

public
class ASTDDBet extends AbstractBet {

  public ASTDDBet(int id) {
    super(id);
  }

  public ASTDDBet(Hbl p, int id) {
    super(p, id);
  }

  public void validate() {
    if (getFortuna()) {
      List<ASTHorseSelection> selections = getHorseSelections();
      if (selections.size() == 2 && selections.stream().noneMatch((s) -> { return s.getFortunaSelect(); })) {
        ParseException.setSemanticError("At least one leg must be open for selections by Fortuna.");
        parser.error(parser.generateParseException().getMessage());
      }
    }
  }
}
/* JavaCC - OriginalChecksum=868050054722ee824d8adfecd6d77deb (do not edit this line) */
