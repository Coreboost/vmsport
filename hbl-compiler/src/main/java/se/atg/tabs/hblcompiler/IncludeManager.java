package se.atg.tabs.hblcompiler;

public class IncludeManager {

  private static IncludeManager instance = null;

  private FileNode rootNode = null;

  public static IncludeManager getInstance() {
    if (instance == null) {
      instance = new IncludeManager();
    }
    return instance;
  }

  public void setRoot(FileNode r) {
    this.rootNode = r;
  }

}
