package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class IncludeTest {

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
}
