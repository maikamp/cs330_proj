package edu.odu.cs.cs350;

import java.io.File;

/**
sourceFiles: Collection
goldCode() -> Collection
storeGoldCode(Configuration c)
 */
class GoldCode {	
	
	/**
	 * useless function I was using to figure out how any of this works
	 * @param path
	 * @return
	 */
	int countFiles(String path) {
		File dir = new File(path);
		
		File[] theFiles = dir.listFiles();
		
		return theFiles.length;
	}

}