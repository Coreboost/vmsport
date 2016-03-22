package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class IncludeTest {

	@Test()
	public void testAccountsSuccess() throws FileNotFoundException, IOException {
		String errors = Helpers.parseFileReturnErrors("IncludeMain.hbl");
		Assert.assertEquals(errors, "");
	}

}
