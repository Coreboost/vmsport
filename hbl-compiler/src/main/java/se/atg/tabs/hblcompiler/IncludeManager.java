package se.atg.tabs.hblcompiler;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IncludeManager {

  private static IncludeManager instance = null;

  private FileNode rootNode = null;
  private File rootFile;

  public static IncludeManager getInstance() {
    if (instance == null) {
      instance = new IncludeManager();
    }
    return instance;
  }

  public void setRoot(String fileName, InputStream originalStream) throws FileNotFoundException, IOException {
    this.rootNode = new FileNode(fileName);
    // Copy input to a temporary file so that we can rewind it (which we couldnt if it is stdin)
    BufferedReader bufReader = new BufferedReader(new InputStreamReader(originalStream));
    rootFile = File.createTempFile("__hblc__", ".hbl");
    String oneLine = bufReader.readLine();
    PrintStream pStream = new PrintStream(rootFile);
    while (oneLine != null) {
      pStream.println(oneLine);
      oneLine = bufReader.readLine();
    }
    pStream.close();
  }

  public FileNode getRoot() {
    return rootNode;
  }

  public InputStream getRootStream()  throws FileNotFoundException {
    return new FileInputStream(rootFile);
  }

  public InputStream getExpandedStream() throws FileNotFoundException, IOException  {
    ArrayList<FileNode> includes = rootNode.getIncludes();
    InputStream rootStream = getRootStream();
    if (includes.size() == 0) {
      return rootStream;
    } else {
      BufferedReader rootReader = new BufferedReader(new InputStreamReader(rootStream));
      File expandedFile = File.createTempFile("__hblc__", ".hbl");
      PrintStream pStream = new PrintStream(expandedFile);
      Integer ind = 0;
      Integer linesReadFromRoot = 0;
      while (ind < includes.size()) {
        while (linesReadFromRoot < includes.get(ind).getIncludedAfterLine()) {
          pStream.println(rootReader.readLine());
          linesReadFromRoot += 1;
        }
        BufferedReader includeReader = new BufferedReader(new FileReader(new File(includes.get(ind).getFileName())));
        String includedLine = includeReader.readLine();
        while (includedLine != null) {
          pStream.println(includedLine);
          includedLine = includeReader.readLine();
        }
        ind += 1;
      }
      String trailingRootLine = rootReader.readLine();
      while (trailingRootLine != null) {
        pStream.println(trailingRootLine);
      }
      pStream.close();
      return new FileInputStream(expandedFile);
    }
  }

}
