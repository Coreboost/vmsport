package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class AccountTest {

	@Test()
	public void testAccountsSuccess() throws FileNotFoundException, IOException {
		String errors = Helpers.parseFileReturnErrors("Accounts.hbl");
		Assert.assertEquals(errors, "");
	}

}
