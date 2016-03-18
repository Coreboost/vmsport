package se.atg.tabs.hblcompiler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class HorseTest {

	@Test()
	public void testHorsesSuccess() throws FileNotFoundException {
		String errors = Helpers.parseFileReturnErrors("Horses.hbl");
		Assert.assertEquals(errors, "");
	}

}
