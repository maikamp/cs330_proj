package edu.odu.cs.cs350;

import static org.junit.Assert.*;


import java.util.Properties;

import org.junit.Test;

public class TestConfiguration {

	@Test
	public void testSetToDefaultValues() {
		Properties prop = new Properties();
		Configuration.setToDefaultValues(prop);
		
		assertEquals("src/main/java", prop.getProperty("gold-location"));
		assertEquals("compile", prop.getProperty("build-command"));
		assertEquals("build/mutation", prop.getProperty("state-location"));
	}


	@Test
	public void testSetToConfigFileValues() {
		fail("WHY");
	}


}
