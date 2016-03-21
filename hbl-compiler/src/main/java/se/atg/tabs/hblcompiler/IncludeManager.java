package se.atg.tabs.hblcompiler;

public class IncludeManager {

  private static IncludeManager instance = null;

  private FileNode rootNode = null;
  private InputStream rootStream;

  public static IncludeManager getInstance() {
    if (instance == null) {
      instance = new IncludeManager();
    }
    return instance;
  }

  public void setRoot(String fileName, InputStream s) {
    this.rootNode = new FileNode(fileName);
    // Copy input to a temporary file so that we can rewind it (which we couldnt if it is stdin)
    BufferedReader bufReader = new BufferedReader(s);
    File temp = File.createTempFile("__hblc__"".hbl");
    String oneLine = bufReader.readLine();
    PrintStream pStream = new PrintStream(temp);
    while (oneLine != null) {
      pStream.println(oneLine);
      oneLine = bufReader.readLine();
    }
    pStream.close();
    rootStream = new FileInputStream(temp);
  }

  public FileNode getRoot() {
    return rootNode;
  }

  public getExpandedStream() {
    ArrayList<FileNode> includes = rootNode.getIncludes();
    rootStream.reset();
    if (includes.size() == 0) {
      return rootStream;
    } else {
      File temp = File.createTempFile("__hblc__"".hbl");
      PrintStream pStream = new PrintStream(temp);
      Integer ind = 0;
      Integer linesReadFromRoot = 0;
      while (ind < includes.size()) {
        while (linesReadFromRoot < includes.get(ind).getIncludedAfterLine()) {
          // Can one really read from the stream like this
          pStream.println(rootStream.readline());
          linesReadFromRoot += 1;
        }
        // Does it really need to be so convoluted
        BufferedReader includeReader = new BufferedReader(new FileInputStream(new File(includes.get(ind).getFileName())));
        String includedLine = includeReader.readLine();
        while (includedLine != null) {
          pStream.println(includedLine);
          includedLine = includeReader.readLine();
        }
        ind += 1;
      }
      String trailingRootLine = rootSteam.readline();
      while (trailingRootLine != null) {
        pStream.println(trailingRootLine);
      }
      pStream.close();
    }
    return new FileInputStream(temp);
  }

}
