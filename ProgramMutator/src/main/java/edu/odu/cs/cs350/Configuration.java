package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

class Configuration {

	/**
	 * Sets properties of prop to the default values.
	 * 
	 * @param prop Properties object to be modified.
	 */
	static void setToDefaultValues(Properties prop) {
		prop.setProperty("gold-location", "src/main/java");
		prop.setProperty("test-location", "src/test/java");
		prop.setProperty("build-command", "compile");
		prop.setProperty("state-location", "build/mutation");
	}

	/**
	 * 
	 * Sets the properties of prop to those specified in the configuration file
	 * found at path.
	 * 
	 * @param prop Properties object to be modified
	 * @param path Path to mutation.settings file to be loaded.
	 * @return True on success. False on failure or if no configuration file is
	 *         found.
	 */
	// need to fix for directory setup
	static Boolean setToConfigFileValues(Properties prop, String dirPath) {
		 File path = new File(dirPath, "mutation.settings");
		
		try {
			FileReader reader = new FileReader(path);
			prop.load(reader);
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
	}

	/**
	 * convenience method-- that is, my convenience. makes default config file.
	 * --BJD
	 * 
	 * @param path
	 * @return
	 */
	static Boolean cleanConfigurationFile(String path) {

		try (OutputStream output = new FileOutputStream(path + "/mutation.settings")) {

			Properties prop = new Properties();
			setToDefaultValues(prop);
			prop.store(output, null);
			output.close();
			return true;
		} catch (IOException e) {
			System.err.println(e);
		}
		return false;
	}

}
