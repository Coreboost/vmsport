package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SmokeTest {

	@Test()
	public void testHorsesSuccess() throws FileNotFoundException {
		String errors = Helpers.parseFileReturnErrors("SmokeTest.hbl");
		Assert.assertEquals(errors, "");
	}

}
