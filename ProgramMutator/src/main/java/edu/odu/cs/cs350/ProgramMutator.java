package edu.odu.cs.cs350;

import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ProgramMutator {
	
	static String desc = "this is a string";	
	static String DEMOPATH = "E:\\Documents\\Eclipse\\Example-3";
	static Properties config = new Properties();
	
	  public static void main(String[] args) {

		Options options = createOptions();
		HelpFormatter helper = new HelpFormatter();
		CommandLineParser parser = new DefaultParser();

	    try {
	      CommandLine cmd = parser.parse(options, args);
	      
	      if (cmd.hasOption("help")) {		    	  
	    	 helper.printHelp( "program", desc, options, null, true); 
	      }
	      if (cmd.hasOption("cleanconfig")) {
	    	 Configuration.cleanConfigurationFile(DEMOPATH);
	      }
	    } catch (ArrayIndexOutOfBoundsException e) {
	    	System.err.println(e);
	    } catch (ParseException e) {
	        System.err.println(e.getMessage());
	    }
		  	  
	    if (!Configuration.setToConfigFileValues(config, DEMOPATH)) {
	    	Configuration.setToDefaultValues(config);
	    }
		
		System.out.println(config);

	  }
	static Options createOptions() {
		
		Options options = new Options();
	    options.addOption("c", "cleanconfig", false, "reset the configuration file to default values");
	    options.addOption("h", "help", false, "print this message");
	    
//	    Option goldloc = Option.builder("g")
//	    		.longOpt("goldloc")
//	    		.desc("set the location of gold version source code")
//	    		.hasArg()
//	    		.argName("path")
//	    		.build();
//	    options.addOption(goldloc);		    
//	    
//	    Option buildtarget = Option.builder("t")
//	    		.longOpt("buildtarget")
//	    		.desc("set the gradle build target to compile without testing")
//	    		.hasArg()
//	    		.argName("path")
//	    		.build();
//	    options.addOption(buildtarget);
//	    
//	    Option stateloc = Option.builder("s")
//	    		.longOpt("stateloc")
//	    		.desc("set the location of project state information")
//	    		.hasArg()
//	    		.argName("path")
//	    		.build();
//	    options.addOption(stateloc);
	    
	    return options;
	}

	
	
	
}
