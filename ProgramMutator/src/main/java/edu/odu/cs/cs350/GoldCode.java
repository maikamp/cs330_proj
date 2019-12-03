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
	
	private String sourceDirectoryString;
	private File sourceDirectory;
	private List<CompilationUnit> sourceCode;
	private JavaParser jParser;
	
	GoldCode(){
		sourceCode = new ArrayList<CompilationUnit>();
		jParser = new JavaParser();
	}
	
	GoldCode(String path){
		sourceDirectoryString = path;
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
	 */
	void addToSourceCode(Path file) {
		
		ParseResult<CompilationUnit> parseUnit;
		try {
			parseUnit = jParser.parse(file);
			if (parseUnit.isSuccessful()) {
				sourceCode.add(parseUnit.getResult().get());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
}
	

	void setSourceDirectory(String path) {
		sourceDirectory = new File(path);
	}
	
	File getSourceDirectory() {
		return this.sourceDirectory;
	}
	
	String getSourceDirectoryString() {
		return this.sourceDirectoryString;
	}
	
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
		
		
		return sourceCode;
	}
	
	List<CompilationUnit> getSourceCode(){
		return this.sourceCode;
	}
}



