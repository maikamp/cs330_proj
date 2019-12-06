package edu.odu.cs.cs350;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

public class TestTestRunner {
	
	@Before
	public void TestGetFile()
	{
		String url = "C:\\Users\\nhughes\\Downloads\\JUnit\\JUnit\\Example-3\\src\\test\\java\\edu\\odu\\cs\\cs350\\examples";
		TestSuite testSubject = new TestSuite(url);
		assertEquals("A", testSubject.getSourceDirectoryString());
	}
	
	
}
