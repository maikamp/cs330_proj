package edu.odu.cs.cs350;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TestTestRunner {
	
<<<<<<< HEAD
	//Test compiles program success
	@Before
	public void TestGetFileS()
	{
		TestRunner testRun = new TestRunner();
		
		//Good file path
		String sourceFilePath = "";
		
		int result = testRun.compileProgram(sourceFilePath);
		
		assertEquals(1, result);
=======
	String TESTPATH = "src/test/resources";
	String[] TESTARRAY = {
			TESTPATH + "/catsample/Cat.java",
			TESTPATH + "/catsample/Greeting.java",
			TESTPATH + "/catsample/Sample.java",
	};
	String[] TESTCLASS = {"catsample.TestCat"};
	
	@Test
	public void testCompileSingleFile() {
		int result = TestRunner.compileProgram(TESTPATH + "/catsample/TestCat.java");
		assertThat(result, is(0));
	}
	
	@Test
	public void testCompileArray() {
		int result = TestRunner.compileProgram(TESTARRAY);
		assertThat(result, is(0));
	}
	@Test
    public void testCompileArrayWithPath() {
		String destRoot = TESTPATH + "/result/";
    	int result = TestRunner.compileProgram(TESTARRAY, destRoot);
    	assertThat(result, is(0));
    }
	
	@Test
	public void testTestGoldCode() {
		int numFailures = TestRunner.testGoldCode(TESTPATH, TESTCLASS);
		assertThat(numFailures, is(1));
>>>>>>> branch 'master' of git@forge350.cs.odu.edu:bdemerch/phase-2-4.git
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
