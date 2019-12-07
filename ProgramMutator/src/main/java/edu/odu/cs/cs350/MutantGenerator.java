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
		TestRunner testEngine;
		MutationGenerator(GoldCode gc){
			sourceCode = gc;
		}		
		void generateArithmeticOperator() {
			int random = (int)(Math.random()*10);
			String ArithmeticOps[] = {"+","-","*","/","%"};
			List<CompilationUnit> code = new ArrayList<CompilationUnit>();
			CompilationUnit compUnit = new CompilationUnit(sourceCode.toString());
			code.add(compUnit);
			MutationOperator Generator = new MutationOperator(code, ArithmeticOps[random].toString());
			
			CompilationUnit modifiedCode =  Generator.getAlteredCode();
			
			int result = testEngine.compileProgram(modifiedCode.toString());
			
			if(result == 0) {
				//Compilation fail
			}else{
				//compilation success
			}
		}
		
		void generateVarOperator() {
			int random = (int)(Math.random()*8);
			String Ops[] = {"int","String","char","boolean","byte","short","long","float","double"};
			List<CompilationUnit> code = new ArrayList<CompilationUnit>();
			CompilationUnit compUnit = new CompilationUnit(sourceCode.toString());
			code.add(compUnit);
			MutationOperator Generator = new MutationOperator(code, Ops[random].toString());
			
			CompilationUnit modifiedCode =  Generator.getAlteredCode();
			
			int result = testEngine.compileProgram(modifiedCode.toString());
			
			if(result == 0) {
				//Compilation fail
			}else{
				//compilation success
			}
		}
		
		void generateLogicalOperator() {
			int random = (int)(Math.random()*8);
			String Ops[] = {"|","&","^","!","||","&&","==","!="};
			List<CompilationUnit> code = new ArrayList<CompilationUnit>();
			CompilationUnit compUnit = new CompilationUnit(sourceCode.toString());
			code.add(compUnit);
			MutationOperator Generator = new MutationOperator(code, Ops[random].toString());
			
			CompilationUnit modifiedCode =  Generator.getAlteredCode();
			
			int result = testEngine.compileProgram(modifiedCode.toString());
			
			if(result == 0) {
				//Compilation fail
			}else{
				//compilation success
			}
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