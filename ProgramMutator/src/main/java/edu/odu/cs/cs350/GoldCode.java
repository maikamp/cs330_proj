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

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

/**
sourceFiles: Collection
goldCode() -> Collection
storeGoldCode(Configuration c)
 */
class GoldCode {
	
	private File sourceDirectory;
	private List<CompilationUnit> sourceCode;
	private JavaParser jParser;
	
	GoldCode(){
		sourceCode = new ArrayList<CompilationUnit>();
		jParser = new JavaParser();
	}
	
	GoldCode(String path){
		sourceDirectory = new File(path);
		jParser = new JavaParser();
		sourceCode = new ArrayList<CompilationUnit>();
		try {
			loadSourceCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	

	/**
	 * Adds a file to the gold source code
	 * @param filePath path to the file to be added
	 */
	void add(Path filePath) {
		
		ParseResult<CompilationUnit> parseUnit;
		try {
			parseUnit = jParser.parse(filePath);
			if (parseUnit.isSuccessful()) {
				sourceCode.add(parseUnit.getResult().get());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
}
	/**
	 * @return list of CompilationUnits
	 */
	List<CompilationUnit> getSourceCode(){
		return this.sourceCode;
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
	 * @return Array of string representations of paths to compilation units
	 */
	String[] getPathStrings() {
		
		int max = this.sourceCode.size();
		String[] result = new String[max];
		for(int i=0; i<max; i++) {
			result[i] = this.sourceCode.get(i).getStorage().get().getPath().toString();
		}
		return result;
	}
	
	/**
	 * Load source code.
	 *
	 * @return the list
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
			    	 add(file);
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
		
		
		return sourceCode;
	}
	
}



