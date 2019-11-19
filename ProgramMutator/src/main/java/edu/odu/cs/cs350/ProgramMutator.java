package edu.odu.cs.cs350;

import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ProgramMutator {

	
	  static final String DEMOPATH = "E:\\Documents\\Eclipse\\Example-2";
	
	  public static void main(String[] args) {


			Options options = createOptions();
			CommandLineParser parser = new DefaultParser();
			Properties config = new Properties();

		    try {
		     	CommandLine cmd = parser.parse(options, args);
		     	String dirPath = "C:/Users/User/Downloads/JUnit/JUnit/Example-2/src/main/java/edu/odu/cs/cs350/examples/";
		     	String dirPathTest = "C:/Users/User/Downloads/JUnit/JUnit/Example-2/src/test/java/edu/odu/cs/cs350/examples/";
			    if (!Configuration.setToConfigFileValues(config, dirPath)) {
			    	Configuration.setToDefaultValues(config);	
			    }
			    //System.err.println(config);
			    
			    //Get gold code
			    GoldCode goldCode = new GoldCode(dirPath);
			    System.out.println("Gold Suite Files: " + goldCode.getSourceCode().size());
			    //Get test code
			    TestSuite testCode = new TestSuite(dirPathTest);
			    System.out.println("TestSuite Files: " + testCode.getSourceCode().size());
			    //Generate Mutants for Testing
			    MutationGenerator GeneratedMutants = new MutationGenerator();
			    System.out.println("Generated Mutations: " + GeneratedMutants.showArrayGenerated());
			    //Put all Mutants into MutationOperator
			    //Run Tests
			    //
			    
		    } catch (ArrayIndexOutOfBoundsException e) {
		    	System.out.println("<name> : Missing operand");
				//System.out.println("Try '<name> --help' for more information.");
		    } catch (ParseException e) {
		        System.err.println(e);
		    }
		  }
	  
		static Options createOptions() {
			
			Options options = new Options();
		    options.addOption("c", "cleanconfig", false, "reset the configuration file to default values");
		    options.addOption("h", "help", false, "print this message");
		    
		    Option goldloc = Option.builder("g")
		    		.longOpt("goldloc")
		    		.desc("set the location of gold version source code")
		    		.hasArg()
		    		.argName("path")
		    		.build();
		    options.addOption(goldloc);		    
//		    
//		    Option buildtarget = Option.builder("t")
//		    		.longOpt("buildtarget")
//		    		.desc("set the gradle build target to compile without testing")
//		    		.hasArg()
//		    		.argName("path")
//		    		.build();
//		    options.addOption(buildtarget);
//		    
//		    Option stateloc = Option.builder("s")
//		    		.longOpt("stateloc")
//		    		.desc("set the location of project state information")
//		    		.hasArg()
//		    		.argName("path")
//		    		.build();
//		    options.addOption(stateloc);
		    
		    return options;
		}

		
		
		
	

	  }

