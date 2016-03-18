package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class AccountTest {

	@Test()
	public void testAccountsSuccess() throws FileNotFoundException {
		String errors = Helpers.parseFileReturnErrors("Accounts.hbl");
		Assert.assertEquals(errors.length(), 0);
	}

}
