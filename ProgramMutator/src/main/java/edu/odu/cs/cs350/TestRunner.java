package edu.odu.cs.cs350;

import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

class TestRunner {
	
    public static Path getAbsolutePath(String fullPath)
    {
        File theFile = new File(fullPath);

        return theFile.getAbsoluteFile().toPath();
    }
    
//	TestRunner(GoldCode gc, TestSuite ts, List<Mutant> mts){
//		this.goldCode = gc;
//		this.testSuite = ts;
//		this.Mutations = mts;
//	}

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

        int result = 
        		compiler.run
        		(null, 
        				outStream, 
        				errStream, 
        				absolutePath);

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
    	
    		Iterable<String> options = null;
    		if(!destRoot.isEmpty()) {
    			options = Arrays.asList( new String[] { "-d", destRoot});
    		}
    		Iterable<? extends JavaFileObject> compUnits =  compiler.getStandardFileManager(null, null, null)
    				.getJavaFileObjectsFromStrings(Arrays.asList(pathStrings));
    		
    		
    		return compiler.getTask(null, null, null, options, null, compUnits).call();
    	}
	
    
    /**
     * Compile a list of Java source files.
     *
     * @param buildRoot location to search for compiled classes
     * @param outStream destination for all "standard out" output (uses default if null)
     * @param errStream destination for all "standard error" output (uses default if null)
     *
     * @return 0 if all tests passed, not 0 on failure or failed test
     */
	static int testGoldCode(String buildRoot, String[] classNames) {
		
		//pretend this isn't here
		try {
			URL newURL = new URL("file:///"+buildRoot+"/");

	        URLClassLoader classLoader = new URLClassLoader(new URL[]{newURL});
	        
	        Class<?>[] theClasses = new Class<?>[classNames.length];
	        for(int i=0; i<classNames.length; i++) {
	            theClasses[i] = classLoader.loadClass(classNames[i]);
	        }
				Request request = Request.classes(theClasses);
		        Result result = new JUnitCore().run(request);
		       
	        return result.getFailureCount();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return -1;
		}
	  }
}

