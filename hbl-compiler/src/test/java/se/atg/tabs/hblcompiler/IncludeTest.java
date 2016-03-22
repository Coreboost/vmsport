package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class IncludeTest {

	@Test()
	public void testNoInclude() throws FileNotFoundException, IOException {
    IncludeManager.getInstance().setRoot("NoInclude.hbl", new FileInputStream("NoInclude.hbl"));
    InputStream inStream = IncludeManager.getInstance().getExpandedStream();
    Scanner scanner = new Scanner(inStream).useDelimiter("\\A");
    String inStreamContents = scanner.hasNext() ? scanner.next() : "";
    Assert.assertEquals(inStreamContents.trim(), "Accounts AA 100.");
	}

}
