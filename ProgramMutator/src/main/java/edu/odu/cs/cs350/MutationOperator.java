package edu.odu.cs.cs350;

import java.util.*;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.expr.Expression;

class MutationOperator {
	
	private List<CompilationUnit> codeToModify;
	private String AlterableMutant;
	private String AlterMutant;
	
	
	//Default constructor for mutant operator class
	MutationOperator(){
		this.AlterableMutant = "";
		this.AlterMutant = "";
		this.codeToModify = new ArrayList<CompilationUnit> ();
	}
	//Receives Code and what needs to be changed.
	//
	MutationOperator(List<CompilationUnit> code, String MutantToChange){
		codeToModify = code;
		AlterableMutant = MutantToChange;
	}
	void getArithmeticOp() {
		/**
		 * Choose from list of arithmetic types
		 * Set as AlterMutant
		 */
		String ArithmeticOps[] = {"+","-","*","/","%","+","-","*","/","%"};
		int random = (int)(Math.random()*10);
		String AlterMutant = ArithmeticOps[random];
	}
	void getBooleanOp() {
		/**
		 * Choose from list of boolean types
		 * Set as AlterMutant
		 */
		String BooleanOps[] = {"|","&","^","!","||","&&","==","!="};
		int random = (int)(Math.random()*8);
		String AlterMutant = BooleanOps[random];
		
	}
	void getConstOp() {
		/**
		 * This function will find a constant variable and change it's value
		 */
	}
	void getVariableOp() {
		/**
		 * Choose from list of variable types
		 * Set as AlterMutant
		 */
		String VarOps[] = {"int","String","char","boolean","byte","short","long","float","double"};
		int random = (int)(Math.random()*8);
		String AlterMutant = VarOps[random];
	}
	CompilationUnit getAlteredCode() {
		CompilationUnit newCode = null;
		/**
		 * Get code from javaParser
		 * Replace all instances of AlterableMutant with AlterMutant
		 * Return updated code
		 */
	    return newCode;
	}
}
