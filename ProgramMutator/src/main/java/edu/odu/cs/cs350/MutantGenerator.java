package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;

class MutationGenerator {
	/**
	 * getArthmeticOperator() -> Collection
	 * getArthmeticOperator() -> Collection
	 * getConstantOperator() -> Collection
	 * getVariableOperator() -> Collection
	 * generateMutants(MutationOperator mop, GoldCode g)
	 * 
	 * based on kennedy's "mutations: Collection" in the outline from our meeting, it 
	 * looks like we need an ADT for mutations in order to hold them in a collection. I've 
	 * added one in this class, but we can move it if it seems more appropriate elsewhere. -Mike
	 */
		GoldCode sourceCode;
		int id;
		int mutantArray[] = new int[100];
		int arithmeticMutantArray[] = new int[100];
		
		MutationGenerator(GoldCode gc){
			sourceCode = gc;
		}
		
		//Generates Arithmetic Operators:
		//Uses a random number to pull a number from MutantArray 
		//Which is used to select one of 5 operators
		//And pushed into arithmeticMutantArray
		
		void generateArithmeticOperator() {
			int random = (int)(Math.random()*10);
			String ArithmeticOps[] = {"+","-","*","/","%"};
			List<CompilationUnit> code = new ArrayList<CompilationUnit>();
			CompilationUnit compUnit = new CompilationUnit(sourceCode.toString());
			code.add(compUnit);
			MutationOperator Generator = new MutationOperator(code, ArithmeticOps[random].toString());
			
			
		}
		
		//Generates Random Numbers Corresponding to Operators
		
		void generateMutants() {
			for (int i=0; i<100; i++) {
				
				int random = (int)(Math.random()*10);
				
				mutantArray[i] =  random;
			}
		}
		
		// Displays the array of mutants generated 
		
		String showArrayGenerated() {
			String nums = "";
			for (int i=0; i<mutantArray.length; i++) {
				nums += Integer.toString(mutantArray[i]) + ", ";
			}
			return nums;
		}

		
	}