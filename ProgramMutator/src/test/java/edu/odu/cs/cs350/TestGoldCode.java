package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestGoldCode {
	
	GoldCode goldCode = new GoldCode();
	GoldCode nullCode = new GoldCode();
	String TESTPATH = "src/test/resources";
	

	@Before
	public void setUp()
	{
		
	}
	
	@Test
	public void testGetSourceDirectory() {
		
		
		goldCode.setSourceDirectory(TESTPATH);
		
		// if I test for exact matching it starts getting picky about \ vs /
		assertThat(goldCode.getSourceDirectory().toString(), stringContainsInOrder(Arrays.asList("src", "test", "resources")));
		assertThat(goldCode.getSourceDirectory().toString(), endsWith("resources"));
	}
	
	@Test
	public void testLoadSourceCode() {
		
		try {
			goldCode.setSourceDirectory(TESTPATH);
			
			// goldCode.add() is called by this
			goldCode.loadSourceCode();
			
			// did it get them all?
			assertEquals(4, goldCode.getSourceCode().size());
			
			// are these the right files? 
			String [] paths = goldCode.getPathStrings();
			assertThat(paths, hasItemInArray(endsWith("Cat.java")));
			assertThat(paths, hasItemInArray(endsWith("Greeting.java")));
			assertThat(paths, hasItemInArray(endsWith("Sample.java")));
			assertThat(paths, hasItemInArray(endsWith("TestCat.java")));
			
			
		} catch (IOException e) {
			fail(e.toString());
		}
	}
	

	
}
