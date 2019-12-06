package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.apache.commons.lang3.StringUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import com.github.javaparser.ast.CompilationUnit;

class TestRunner {
	
	private GoldCode goldCode;
	private TestSuite testSuite;
	private List<Mutant> Mutations = new ArrayList<Mutant>();
	private List<Mutant> ValidMutations = new ArrayList<Mutant>();
	private List<Mutant> InvalidMutations = new ArrayList<Mutant>();
	
    public static Path getAbsolutePath(String fullPath)
    {
        File theFile = new File(fullPath);

        return theFile.getAbsoluteFile().toPath();
    }

    /**
     * Compile a single simple (single source file) Java program.
     *
     * @param sourceFilePath Path to Java source file to compile
     *
     * @return 0 if compilation was successful, not 0 on failure
     */
    public static int compileProgram(String sourceFilePath)
    {
        Path absolutePath = getAbsolutePath(sourceFilePath);

        return compileProgram(absolutePath.toString(), null, null);
    }
    
    /**
     * Compile a single simple (single source file) Java program.
     *
     * @param absolutePath absolute path to file to compile
     * @param outStream destination for all "standard out" output
     * @param errStream destination for all "standard error" output
     *
     * @return 0 if compilation was successful, not 0 on failure
     */
    public static int compileProgram(String absolutePath,
                                     OutputStream outStream,
                                     OutputStream errStream)
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int result = compiler.run(null, outStream, errStream, absolutePath);

        return result;
    }
    
    
    /**
     * Compile a list of Java source files.
     *
     * @param pathStrings array of String representations of
     *  absolute paths to files to compile
     *
     * @return 0 if compilation was successful, not 0 on failure
     */
    public static int compileProgram(String[] filePaths) {
    	
    	if(!compileAll("", filePaths, null, null)) {
    		return 1;
    	}
    	
    	return 0;
    }
    
    /**
     * Compile a list of Java source files.
     *
     * @param pathStrings array of String representations of
     *  absolute paths to files to compile
     *  @param destRoot 
     *
     * @return 0 if compilation was successful, not 0 on failure
     */
    public static int compileProgram(String[] filePaths, String destRoot) {

        if(!compileAll(destRoot, filePaths, null, null)) {
        	return 1;
        }
        
        return 0;
    }

    /**
     * Compile a list of Java source files.
     *
     * @param pathStrings array of String representations of
     *  absolute paths to files to compile
     * @param outStream destination for all "standard out" output (uses default if null)
     * @param errStream destination for all "standard error" output (uses default if null)
     *
     * @return 0 if compilation was successful, not 0 on failure
     */
    static boolean compileAll( String destRoot, String[] pathStrings, OutputStream outStream,
    		OutputStream errStream)
    {
		//modified from:
		//https://stackoverflow.com/questions/9665768/javacompiler-set-the-compiled-class-output-folder
    	
    		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    		String path = "E:\\Documents\\Eclipse\\Example-5\\src\\main\\java";
    		
    		Iterable<String> options = Arrays.asList( new String[] { "-d", destRoot});
    		
    		Iterable<? extends JavaFileObject> compUnits =  compiler.getStandardFileManager(null, null, null)
    				.getJavaFileObjectsFromStrings(Arrays.asList(pathStrings));
    		
    		
    		return compiler.getTask(null, null, null, options, null, compUnits).call();
    	}
	   
    
	TestRunner(GoldCode gc, TestSuite ts, List<Mutant> mts){
		this.goldCode = gc;
		this.testSuite = ts;
		this.Mutations = mts;
	}
	
	void RunTest() {
		/**
		 * Get folder containing codes Gold Code 
		 * Get folder containing codes Test Suite
		 */
        String sourceFilePathTc = testSuite.getSourceDirectoryString();
        String sourceFilePathGc = goldCode.getSourceDirectory().toString();
		/**
		 * Get files in GoldCode Path
		 * Get files in TestSuite Path
		 */
        File goldCodeFolder  = new File(sourceFilePathGc);
        File testCodeFolder  = new File(sourceFilePathTc);
        /**
         * Obtains list of files from each directory
         */
        File[] listOfGCFiles = goldCodeFolder.listFiles();
        File[] listOfTSFiles = testCodeFolder.listFiles();
        
        /**
         * Checks that each file compiles without errors
         * if fail: send error message and exit program
         */
        //Test Gold Code files
        for (int i = 0; i < listOfGCFiles.length; i++) {
        	  if (listOfGCFiles[i].isFile()) {
        		  if (compileProgram(listOfGCFiles[i].getPath()) != 0) {
        	            System.out.println("Compilation Failed for file: " +listOfGCFiles[i].getName());
        	            System.out.println("Please fix and try again");
        	            System.exit(1);
        	        }
        	  } 
        	}
      //Test Test Suite files
        for (int i = 0; i < listOfTSFiles.length; i++) {
      	  if (listOfTSFiles[i].isFile()) {
      		  if (compileProgram(listOfTSFiles[i].getPath()) != 0) {
      	            System.out.println("Compilation Failed for file: " +listOfTSFiles[i].getName());
      	            System.out.println("Please fix and try again");
      	            System.exit(1);
      	        }
      	  } 
      	}
        System.out.printf("Compilation Succeeded proceeding with test...");
        
        //Begin Mutation test
        /**
         * 1. Get file from path
         * 2. Generate Mutation test based on source code
         * 3. Replace source code with new mutation test
         * 4. Compile and run new code (if it passes its a failure, JUNIT test fail when modified as modified code should NOT pass all test) 
         */
        
        /* Taking this section out until it's updated, to let check out the other runner issues for CI
        for (int i = 0; i < listOfTSFiles.length; i++) {
        	  if (listOfTSFiles[i].isFile()) {
        		  try {
        			 String strPath = listOfTSFiles[i].getPath();
        		     String contents = new String(Files.readAllBytes(Paths.get(strPath)));
        		     
        		     MutationGenerator mutantGen = new MutationGenerator(.getPath());
        		    } catch (IOException e) {
        		    	
        		      e.printStackTrace();
        		      
        		    }
        		  
        	  } 
        	}
        */
	}
	void TestCase(Mutant workingSetA) {
			try {
	            int result = 0; //Result of compiling code
	        } catch ( Exception e ) {
	        }
	}
	
	static int testGoldCode(String buildRoot, String[] classes) {
		
		//pretend this isn't here
		try {
			URL newURL = new URL("file:///"+buildRoot+"/");

	        URLClassLoader classLoader = new URLClassLoader(new URL[]{newURL});
	        
	        for(String classname: classes) {
	            Class<?> clazz = classLoader.loadClass(classname);

				Request request = Request.aClass(clazz);
		        Result result = new JUnitCore().run(request);
		        if (!result.wasSuccessful()) {
		        	return 1;
		        }
	        }
	        return 0;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	  }
}

