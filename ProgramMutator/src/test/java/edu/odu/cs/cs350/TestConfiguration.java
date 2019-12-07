package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


import java.util.Properties;

import org.junit.Test;

public class TestConfiguration {
	
	String TESTPATH = "src/test/resources";

	@Test
	public void testSetToDefaultValues() {
		Properties prop = new Properties();
		Configuration.setToDefaultValues(prop);
		
		assertThat(prop.getProperty("gold-location"), is("src/main/java"));
		assertThat(prop.getProperty("test-location"), is("src/test/java"));
		assertThat(prop.getProperty("build-command"), is("compile"));
		assertThat(prop.getProperty("state-location"), is("build/mutation"));
	}


	@Test
	public void testSetToConfigFileValues() {
		Configuration.cleanConfigurationFile(TESTPATH);
		
		Properties prop = new Properties();
		Configuration.setToConfigFileValues(prop, TESTPATH);
		
		assertThat(prop.getProperty("gold-location"), is("src/main/java"));
		assertThat(prop.getProperty("test-location"), is("src/test/java"));
		assertThat(prop.getProperty("build-command"), is("compile"));
		assertThat(prop.getProperty("state-location"), is("build/mutation"));
		
	}


}
