/* Generated By:JJTree: Do not edit this line. ASTResultList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package se.atg.tabs.hblcompiler;
import javax.json.*;
import java.util.List;
import java.util.ArrayList;
public
class ASTResultList extends SimpleNode {
  private ArrayList<List<Integer>> entries = new ArrayList<List<Integer>>();
  public ASTResultList(int id) {
    super(id);
  }

  public ASTResultList(Hbl p, int id) {
    super(p, id);
  }

  public void addEntry(List<Integer> entry) {
    entries.add(entry);
  }

  public List<List<Integer>> getResults() {
    return entries;
  }

  public void generateSpecifics(JsonObjectBuilder builder) {
    JsonArrayBuilder myBuilder = Json.createArrayBuilder();
    entries.forEach(entry -> {
      if (entry.size() == 1) {
        myBuilder.add(entry.get(0));
      } else {
        JsonArrayBuilder otherBuilder = Json.createArrayBuilder();
        entry.forEach(horse -> otherBuilder.add(horse));
        myBuilder.add(otherBuilder.build());
      }
    });
    builder.add("resultList", myBuilder.build());
  }

}
/* JavaCC - OriginalChecksum=ce4560c5d745a3913acebb698261f432 (do not edit this line) */
