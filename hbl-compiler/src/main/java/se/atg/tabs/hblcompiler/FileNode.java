package se.atg.tabs.hblcompiler;

import java.util.ArrayList;
import java.io.File;


public class FileNode {
  private String fileName;
  private Integer length;
  private Integer includedInPlaceOfLine;
  private ArrayList<FileNode> includes = new ArrayList<FileNode>();

  public FileNode(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void addIncludedFileInPlaceOfLine(String fileName, Integer lineNumber) {
    FileNode includedFile = new FileNode(fileName);
    includedFile.setIncludedInPlaceOfLine(lineNumber);
    includes.add(includedFile);
  }

  public ArrayList<FileNode> getIncludes() {
    return includes;
  }

  public void setLength(Integer l) {
    this.length = l;
  }

  public Integer getLength() {
    return this.length;
  }

  public void setIncludedInPlaceOfLine(Integer l) {
    this.includedInPlaceOfLine = l;
  }

  public Integer getIncludedInPlaceOfLine() {
    return this.includedInPlaceOfLine;
  }

}
