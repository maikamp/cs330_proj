package edu.odu.cs.cs350;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

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
     * @param absolutePath absolute path to file to complile
     * @param outStream destination for all "standard out" output
     * @param errStream destination for all "standard error" output
     *
     * @return 0 if compilation was successfull, not 0 on failure
     */
    public static int compileProgram(String absolutePath,
                                     OutputStream outStream,
                                     OutputStream errStream)
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int result = compiler.run(null, outStream, errStream, absolutePath);

        return result;
    }
	
	TestRunner(GoldCode gc, TestSuite ts, List<Mutant> mts){
		this.goldCode = gc;
		this.testSuite = ts;
		this.Mutations = mts;
	}
	
	void RunTest() {
        String sourceFilePathTc = testSuite.getSourceDirectoryString();
        String sourceFilePathGc = goldCode.getSourceDirectoryString();
        
        if (compileProgram(sourceFilePathTc) != 0) {
            System.out.println("Compilation Failed");
            System.exit(1);
        }

        System.out.printf("Compilation Succeeded for %s%n",
                          getAbsolutePath(sourceFilePathTc));
	}
	void TestCase(Mutant workingSetA) {
			try {
	            int result = 0; //Result of compiling code
	        } catch ( Exception e ) {
	        
	        }
	}
}

