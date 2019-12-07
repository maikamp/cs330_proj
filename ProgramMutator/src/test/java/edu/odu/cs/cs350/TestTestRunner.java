package edu.odu.cs.cs350;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

public class TestTestRunner {
	
	//Test compiles program success
	@Before
	public void TestGetFileS()
	{
		TestRunner testRun = new TestRunner();
		
		//Good file path
		String sourceFilePath = "";
		
		int result = testRun.compileProgram(sourceFilePath);
		
		assertEquals(1, result);
	}
	//Test compiles program fail
	@Before
	public void TestGetFileF()
	{
		TestRunner testRun = new TestRunner();
		
		//Bad file path
		String sourceFilePath = "";
		
		int result = testRun.compileProgram(sourceFilePath);
		
		assertEquals(0, result);
	}
}
