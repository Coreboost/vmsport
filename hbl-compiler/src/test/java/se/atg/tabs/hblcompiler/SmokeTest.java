package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class SmokeTest {

	@Test()
	public void testSmokeTest() throws FileNotFoundException, IOException {
		String errors = Helpers.parseFileReturnErrors("SmokeTest.hbl");
		Assert.assertEquals(errors, "");
	}

}
