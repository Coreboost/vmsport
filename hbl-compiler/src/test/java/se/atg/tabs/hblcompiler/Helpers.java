package se.atg.tabs.hblcompiler;

import java.io.FileNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.File;

public class Helpers {

	static public String parseFileReturnErrors(String fileName) throws FileNotFoundException {
		ByteArrayOutputStream baoStream = new ByteArrayOutputStream();
		PrintStream errorStream = new PrintStream(baoStream);
		FileInputStream inStream = new FileInputStream(new File(fileName));
		Hbl.parse(inStream, null, errorStream);
		return baoStream.toString();
	}

}
