package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import se.atg.tabs.hblcompiler.Hbl;

public class AccountTest {

	@Test()
	public void testAccountsSuccess() throws FileNotFoundException {
		ByteArrayOutputStream baoStream = new ByteArrayOutputStream();
		PrintStream errorStream = new PrintStream(baoStream);
		InputStream inStream = new FileInputStream(new File("Accounts.hbl"));
		Hbl.parse(inStream, null, errorStream);
		String errors = baoStream.toString();
		Assert.assertEquals(errors.length(), 0);
	}

}
