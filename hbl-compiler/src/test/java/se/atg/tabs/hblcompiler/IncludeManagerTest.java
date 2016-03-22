package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class IncludeManagerTest {

	private String getExpandedContent() throws FileNotFoundException, IOException {
    InputStream inStream = IncludeManager.getInstance().getExpandedStream();
    Scanner scanner = new Scanner(inStream).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
	}

	@Test()
	public void testNoInclude() throws FileNotFoundException, IOException {
		IncludeManager.getInstance().setRoot("NoInclude.hbl", new FileInputStream("NoInclude.hbl"));
		String expanded = getExpandedContent();
    Assert.assertEquals(expanded.trim(), "Some Text.");
	}

	@Test()
	public void testIncludeFirst() throws FileNotFoundException, IOException {
		IncludeManager.getInstance().setRoot("IncludeFirst.hbl", new FileInputStream("IncludeFirst.hbl"));
		IncludeManager.getInstance().getRoot().addIncludedFileInPlaceOfLine("Included.hbl", 0);
		String expanded = getExpandedContent();
    Assert.assertEquals(expanded.trim(), "Included Line\nSecond Line");
	}

	@Test()
	public void testIncludeLast() throws FileNotFoundException, IOException {
		IncludeManager.getInstance().setRoot("IncludeLast.hbl", new FileInputStream("IncludeLast.hbl"));
		IncludeManager.getInstance().getRoot().addIncludedFileInPlaceOfLine("Included.hbl", 1);
		String expanded = getExpandedContent();
    Assert.assertEquals(expanded.trim(), "First Line\nIncluded Line");
	}

	@Test()
	public void testIncludeMiddle() throws FileNotFoundException, IOException {
		IncludeManager.getInstance().setRoot("IncludeMiddle.hbl", new FileInputStream("IncludeMiddle.hbl"));
		IncludeManager.getInstance().getRoot().addIncludedFileInPlaceOfLine("Included.hbl", 1);
		String expanded = getExpandedContent();
    Assert.assertEquals(expanded.trim(), "First Line\nIncluded Line\nThird Line");
	}

	@Test()
	public void testIncludeMultiple() throws FileNotFoundException, IOException {
		IncludeManager.getInstance().setRoot("IncludeMultiple.hbl", new FileInputStream("IncludeMultiple.hbl"));
		IncludeManager.getInstance().getRoot().addIncludedFileInPlaceOfLine("Included.hbl", 1);
		IncludeManager.getInstance().getRoot().addIncludedFileInPlaceOfLine("AnotherIncluded.hbl", 2);
		String expanded = getExpandedContent();
    Assert.assertEquals(expanded.trim(), "First Line\nIncluded Line\nAnother Included Line\nFourth Line");
	}
}
