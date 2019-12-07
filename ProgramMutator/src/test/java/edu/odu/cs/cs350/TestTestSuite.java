package edu.odu.cs.cs350;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class TestTestSuite {
	TestSuite testCode = new TestSuite();
	TestSuite nullCode = new TestSuite();
	String TESTPATH = "src/test/resources";
	
	


	@Test
	public void testGetSourceDirectory() {

		testCode.setSourceDirectory(TESTPATH);
		
		// if I test for exact matching it starts getting picky about \ vs /
		assertThat(testCode.getSourceDirectory().toString(), stringContainsInOrder(Arrays.asList("src", "test", "resources")));
		assertThat(testCode.getSourceDirectory().toString(), endsWith("resources"));
	}
		
	@Test
	public void testLoadSourceCode() {
		try {
			testCode.setSourceDirectory(TESTPATH);
			
			// testCode.add() is called by this
			testCode.loadSourceCode();
			
			// did it get them all?
			assertEquals(4, testCode.getSourceCode().size());
			
			// are these the right files? 
			String [] paths = testCode.getPathStrings();
			assertThat(paths, hasItemInArray(endsWith("Cat.java")));
			assertThat(paths, hasItemInArray(endsWith("Greeting.java")));
			assertThat(paths, hasItemInArray(endsWith("Sample.java")));
			assertThat(paths, hasItemInArray(endsWith("TestCat.java")));
			
			
		} catch (IOException e) {
			fail(e.toString());
		}
	}
	@Test
	public void testGetClasses() {
		testCode.setSourceDirectory(TESTPATH);
		try {
			testCode.loadSourceCode();
			String[] theClasses = testCode.getClasses();
			
			assertThat(theClasses, hasItemInArray("catsample.Cat"));
			assertThat(theClasses, hasItemInArray("catsample.Greeting"));
			assertThat(theClasses, hasItemInArray("catsample.Sample"));
			assertThat(theClasses, hasItemInArray("catsample.TestCat"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail(e.toString());
		}
		
		
		
	}
}



