package edu.odu.cs.cs350;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

class TestSuite {
	
	
	private File sourceDirectory;
	private List<CompilationUnit> testCode;
	private JavaParser jParser;
	
	TestSuite(){
		testCode = new ArrayList<CompilationUnit>();
		jParser = new JavaParser();
	}
	
	/**
	 * Instantiates a new test suite.
	 *
	 * @param path the path
	 */
	TestSuite(String path){
		sourceDirectory = new File(path);
		jParser = new JavaParser();
		testCode = new ArrayList<CompilationUnit>();
		try {
			loadSourceCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	
	/**
	 * Adds a file to the test source code
	 * @param filePath path to the file to be added
	 */
	void addToSourceCode(Path file) {
		
		ParseResult<CompilationUnit> parseUnit;
		try {
			parseUnit = jParser.parse(file);
			if (parseUnit.isSuccessful()) {
				testCode.add(parseUnit.getResult().get());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
}
	
	/**
	 * @return Array of string representations of paths to compilation units
	 */
	String[] getPathStrings() {
		
		int max = this.testCode.size();
		String[] result = new String[max];
		for(int i=0; i<max; i++) {
			result[i] = this.testCode.get(i).getStorage().get().getPath().toString();
		}
		return result;
	}
	
	/**
	 * @return Array of strings representing fully-qualified class names
	 */
	String[] getClasses() {
		
		int max = this.testCode.size();
		String[] classes = new String[max];
		
		for(int i=0; i<max; i++) {
			String packagedec = this.testCode.get(i).getPackageDeclaration().get().getName().asString();
	      	String filename = this.testCode.get(i).getStorage().get().getFileName();
	      	classes[i]= packagedec + "." +StringUtils.stripEnd(filename, ".java");
		}
	      return classes;	
	}
		
	/**
	 * Sets the source root directory.
	 *
	 * @param path the new source root directory
	 */
	void setSourceDirectory(String path) {
		sourceDirectory = new File(path);
	}
	
	/**
	 * @return File representing root directory of source code
	 */
	File getSourceDirectory() {
		
		return this.sourceDirectory;
	}

	
	/**
	 * Load source code.
	 *
	 * @return the list of CompilationUnit objects
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	List<CompilationUnit> loadSourceCode() throws IOException {
		if(!sourceDirectory.exists()) {
			String message = "Error: No directory found at '" + sourceDirectory.toString()+ "'";
			throw new IOException(message);
		}
		Path start = sourceDirectory.toPath();
		 try {
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			     @Override
			     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			         throws IOException
			     {
			    	 addToSourceCode(file);
			         return FileVisitResult.CONTINUE;
			     }
			     @Override
			     public FileVisitResult postVisitDirectory(Path dir, IOException e)
			         throws IOException
			     {
			         if (e == null) {
			             return FileVisitResult.CONTINUE;
			         } else {
			             throw e;
			         }
			     }
			 });
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testCode;
	}
	
	/**
	 * @return list of CompilationUnits
	 */
	List<CompilationUnit> getSourceCode(){
		return this.testCode;
	}
}



