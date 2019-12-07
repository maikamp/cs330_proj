package edu.odu.cs.cs350;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.*;

public class TestMutationGenerator {
	
	//Test compiles program success
	
	@Before
	public void TestGenerateMutantsArithS()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Valid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateArithmeticOperator();
		assertEquals(1, gen.getLastResult());
			
	}
	@Before
	public void TestGenerateMutantLogicS()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Valid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateLogicalOperator();
		assertEquals(1, gen.getLastResult());
			
	}
	@Before
	public void TestGenerateMutantVarS()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Valid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateVarOperator();
		assertEquals(1, gen.getLastResult());
			
	}
	@Before
	public void TestGenerateMutantsArithF()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Invalid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateArithmeticOperator();
		assertEquals(0, gen.getLastResult());
		
	}
	@Before
	public void TestGenerateMutantsLogicF()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Invalid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateLogicalOperator();
		assertEquals(0, gen.getLastResult());
		
		
	}
	@Before
	public void TestGenerateMutantsVarF()
	{
		GoldCode goldCode = new GoldCode();
		String validPathToGoldCodeString = "";//Invalid gold code filepath
		Path validPathToGoldCode = Paths.get(validPathToGoldCodeString);
		goldCode.add(validPathToGoldCode);
		
		MutationGenerator gen = new MutationGenerator(goldCode);
		
		gen.generateVarOperator();
		assertEquals(0, gen.getLastResult());
		}
	
}