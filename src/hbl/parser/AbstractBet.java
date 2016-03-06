/* Generated By:JJTree: Do not edit this line. ASTDDBet.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.HashSet;
import javax.json.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public
abstract class AbstractBet extends SimpleNode {
  private static HashSet<String> betIDs = new HashSet<String>();

  private String betID = null;
  private String accountID = null;
  private Integer amount = -1;
  private Boolean fortuna=false;
  private Boolean boost = false;
  private Integer multiplier = 1;
  private Integer repeatCount = 1;


  public AbstractBet(int id) {
    super(id);
  }

  public AbstractBet(Hbl p, int id) {
    super(p, id);
  }

  public List<ASTHorseSelection> getHorseSelections() {
    ArrayList<ASTHorseSelection> selections = new ArrayList<ASTHorseSelection>();
    Arrays.stream(children).
      filter((c) -> c instanceof ASTHorseSelection).
      forEach((hs) -> selections.add((ASTHorseSelection)hs));
    return selections;
  }

  public void setAccountID(String id) {
    accountID = id;
    if (!ASTAccountSpec.accountExists(id)) {
      ParseException.setSemanticError("The account " + id + " is not defined.");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public void setBetID(String id) {
    betID = id;
    if (betIDs.contains(id)) {
      ParseException.setSemanticError("A bet with name " + id + " is already defined.");
      parser.error(parser.generateParseException().getMessage());
    } else {
      betIDs.add(id);
    }
  }

  public void setAmount(Integer a) {
    amount = a;
  }

  public void setFortuna(Boolean f) {
    fortuna = f;
  }

  public Boolean getFortuna() {
    return fortuna;
  }

  public void setBoost(Boolean b) {
    boost = b;
  }

  public void setMultiplier(Integer m) {
    multiplier = m;
  }

  public void setRepeatCount(Integer r) {
    repeatCount = r;
  }

  public void validate(ASTProgram program) {
    getHorseSelections().forEach((hs) -> {
      Integer legInPool = hs.getLeg();
      ArrayList<Integer> allSelections = new ArrayList<Integer>(hs.getHorses());
      allSelections.addAll(hs.getReserves());
      AbstractPoolSpec poolSpec = getPoolSpec(program);
      Integer actualLeg = poolSpec.getActualLeg(legInPool);
      allSelections.forEach((selected) -> {
        if (!program.getLeg(actualLeg).isValidFinisher(selected)) {
          ParseException.setSemanticError(selected + " is not a valid selection for leg " + legInPool + "." );
          parser.error(parser.generateParseException().getMessage());
        }
      });
    });
  }

  protected abstract AbstractPoolSpec getPoolSpec(ASTProgram program);

  public void generateSpecifics(JsonObjectBuilder builder) {
    if (betID != null) {
      builder.add("betID", betID);
    }
    if (fortuna) {
      builder.add("fortuna", fortuna);
    }
    if (accountID != null) {
      builder.add("accountID", accountID);
    }
    if (multiplier > 1) {
      builder.add("multiplier", multiplier);
    }
    if (repeatCount > 1) {
      builder.add("repeat", repeatCount);
    }
    if (boost) {
      builder.add("boost", boost);
    }
    if (amount >= 0) {
      builder.add("amount", amount);
    }
  }
}
/* JavaCC - OriginalChecksum=868050054722ee824d8adfecd6d77deb (do not edit this line) */
