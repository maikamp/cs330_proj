package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class TestRunner {
	
	private GoldCode goldCode;
	private TestSuite testSuite;
	private List<Mutant> Mutations = new ArrayList<Mutant>();
	private List<Mutant> ValidMutations = new ArrayList<Mutant>();
	private List<Mutant> InvalidMutations = new ArrayList<Mutant>();
	
	TestRunner(GoldCode gc, TestSuite ts, List<Mutant> mts){
		this.goldCode = gc;
		this.testSuite = ts;
		this.Mutations = mts;
	}
	
	void RunTest() {
		if(Mutations.size() == InvalidMutations.size()) {
			System.err.println("All Test Cases are Invalid please re-generate Mutations.");
		}else {
			for(int i = 0; i<ValidMutations.size(); i++) {
				TestCase(ValidMutations.get(i));
			}
		}
	}
	void TestCase(Mutant workingSetA) {
			try {
	            int result = 0; //Result of compiling code
	        } catch ( Exception e ) {
	        
	        }
	}
}

