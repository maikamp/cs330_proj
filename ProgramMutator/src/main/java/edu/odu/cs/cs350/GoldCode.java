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
	
	private String sourceRootDirectoryString;
	private File sourceRootDirectory;
	private List<CompilationUnit> sourceCode;
	private JavaParser jParser;
	
	GoldCode(){
		sourceCode = new ArrayList<CompilationUnit>();
		jParser = new JavaParser();
	}
	
	GoldCode(String path){
		sourceRootDirectoryString = path;
		sourceRootDirectory = new File(path);
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
	

	void setSourceRootDirectory(String path) {
		sourceRootDirectory = new File(path);
	}
	
	File getSourceRootDirectory() {
		
		return this.sourceRootDirectory;
	}
	
	String getSourceRootDirectoryString() {
		
		return this.sourceRootDirectoryString;
	}
	
	String[] getPathStrings() {
		
		int max = this.sourceCode.size();
		String[] result = new String[max];
		for(int i=0; i<max; i++) {
			result[i] = this.sourceCode.get(i).getStorage().get().getPath().toString();
		}
		return result;
	}
	
	List<CompilationUnit> loadSourceCode() throws IOException {
		if(!sourceRootDirectory.exists()) {
			String message = "Error: No directory found at '" + sourceRootDirectory.toString()+ "'";
			throw new IOException(message);
		}
		Path start = sourceRootDirectory.toPath();
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



