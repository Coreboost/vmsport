/* Generated By:JJTree: Do not edit this line. ASTProgram.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import javax.json.*;

public
class ASTProgram extends SimpleNode {
  private String track;
  private String date;

  private static ArrayList<ASTProgram> programs = new ArrayList<ASTProgram>();

  public ASTProgram(int id) {
    super(id);
    programs.add(this);
  }

  public ASTProgram(Hbl p, int id) {
    super(p, id);
    programs.add(this);
  }

  public static ASTProgram getProgram(String track, String date) {
    Optional found = programs.
      stream().
      filter(p -> p.getDate().equals(date) && p.getTrack().equals(track)).
      findAny();
    if (found.isPresent()) {
        return (ASTProgram)found.get();
    } else {
      return null;
    }
  }

  public static Boolean programExists(ASTProgram c) {
    return programs.
            stream().
            anyMatch(p -> c != p && (p.getDate().equals(c.getDate()) && p.getTrack().equals(c.getTrack())));
  }

  public static Boolean programExists(String track, String date) {
    return programs.
        stream().
        anyMatch(p -> p.getDate().equals(date) && p.getTrack().equals(track));
  }

  public void setTrack(String t) {
    track = t;
    if (!ASTTrackSpec.trackExists(t)) {
      ParseException.setSemanticError("The track " + t + " is not defined.");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public String getTrack() {
    return track;
  }

  public void setDate(String d) {
    date = d;
    if (ASTProgram.programExists(this)) {
      ParseException.setSemanticError("A program is already defined for " + track + " on " + d + ".");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public String getDate() {
    return date;
  }

  public List<ASTLegSpec> getLegSpecs() {
    ASTLegSpecs legSpecsObject = (ASTLegSpecs)Arrays.stream(children).
      filter(c -> c instanceof ASTLegSpecs).
      findAny().
      get();
    return legSpecsObject.getLegSpecs();
  }

  public List<AbstractPoolSpec> getPoolSpecs() {
    ASTPoolSpecs poolSpecsObject = (ASTPoolSpecs)Arrays.stream(children).
      filter(c -> c instanceof ASTPoolSpecs).
      findAny().
      get();
    return poolSpecsObject.getPoolSpecs();
  }

  public ASTLegSpec getLeg(Integer legNo) {
    return getLegSpecs().
          stream().
          filter((ls) -> ls.getLeg() == legNo).
          findAny().
          get();
  }


  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("track", track);
    builder.add("date", date);
  }

}
/* JavaCC - OriginalChecksum=ed62792abe71dd564ee3dcdd5ed738e3 (do not edit this line) */
