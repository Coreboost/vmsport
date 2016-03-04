/* Generated By:JJTree: Do not edit this line. ASTMeeting.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import javax.json.*;
public
class ASTMeeting extends SimpleNode {
  private String track;
  private String date;

  public ASTMeeting(int id) {
    super(id);
  }

  public ASTMeeting(Hbl p, int id) {
    super(p, id);
  }

  public void setTrack(String t) {
    track = t;
    if (!ASTTrackSpec.trackNames.contains(t)) {
      ParseException.setSemanticError("The track " + t + " is not defined.");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public void setDate(String d) {
    date = d;
    if (!ASTProgram.programExists(track, date)) {
      ParseException.setSemanticError("No program is defined for " + track + " on " + date + ".");
      parser.error(parser.generateParseException().getMessage());
    }
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    builder.add("track", track);
    builder.add("date", date);
  }
}
/* JavaCC - OriginalChecksum=2607718fc99ec42de0641dee96a7094f (do not edit this line) */
