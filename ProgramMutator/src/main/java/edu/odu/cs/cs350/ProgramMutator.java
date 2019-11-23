package edu.odu.cs.cs350;

import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
//import org.apache.commons.cli.HelpFormatter;

public class ProgramMutator {

	
	  static final String DEMOPATH = "E:\\Documents\\Eclipse\\Example-2";
	
	  public static void main(String[] args) {


			Options options = createOptions();
			CommandLineParser parser = new DefaultParser();
			Properties config = new Properties();

		    try {
		     	CommandLine cmd = parser.parse(options, args);
		     	String dirPath = cmd.getArgs()[0];
		     	String dirPathTest = dirPath + "/src/test/java";
			    if (!Configuration.setToConfigFileValues(config, dirPath)) {
			    	Configuration.setToDefaultValues(config);	
			    }
			    //System.err.println(config);
			   
			    MutationTestState state = new MutationTestState();
			    
			    if( cmd.hasOption( "describe" ) ) {
			    	System.out.println( state.getMutantByID(Integer.parseInt(cmd.getOptionValue( "describe" ))));			    	
			    }
			    if( cmd.hasOption( "list" ) ) {
			       state.printLiveMutants();
			    }
			    
			    //Get gold code
			    GoldCode goldCode = new GoldCode(dirPath);
			    System.out.println("Gold Files: " + goldCode.getSourceCode().size());
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
				System.out.println("Try '<name> --help' for more information.");
		    } catch(IndexOutOfBoundsException e) {
		    	System.out.println("Invalid mutant ID");
		    }
		    catch (ParseException e) {
		        System.err.println(e);
		    }
		  }
	  
		static Options createOptions() {
			
			Options options = new Options();
		    options.addOption("c", "cleanconfig", false, "reset the configuration file to default values");
		    options.addOption("h", "help", false, "print this message");

		    Option describe = Option.builder("d")
		    		.longOpt("describe")
		    		.desc("get a description of a mutant")
		    		.hasArg()
		    		.argName("mutantId")
		    		.build();
		    options.addOption(describe);
		    
		    Option list = Option.builder("l")
		    		.longOpt("list")
		    		.desc("list all live mutants")
		    		.build();
		    options.addOption(list);
		    
		    return options;
		}

		
		
		
	

	  }

