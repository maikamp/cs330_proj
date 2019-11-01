package edu.odu.cs.cs350;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ProgramMutator {
	
	  public static void main(String[] args) {

		    Options options = new Options();
		    CommandLineParser parser = new DefaultParser();
		    HelpFormatter formatter = new HelpFormatter();

		    
		    try {
		      CommandLine cmd = parser.parse(options, args);
		      String dirPath = cmd.getArgs()[0];
		          
		    } 
		    catch (ArrayIndexOutOfBoundsException e) {
		    	System.err.println(e);
		    }
		    catch (ParseException e) {
		      System.err.println(e.getMessage());
		    }
		  }
		  }



