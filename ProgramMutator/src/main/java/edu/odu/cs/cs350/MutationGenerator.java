package edu.odu.cs.cs350;

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
		int id;
		int mutantArray[] = new int[100];
		int arithmeticMutantArray[] = new int[100];
		
		MutationGenerator(){
			generateMutants();
		}
		
		//Generates Arithmetic Operators:
		//Uses a random number to pull a number from MutantArray 
		//Which is used to select one of 5 operators
		//And pushed into arithmeticMutantArray
		
		void generateArithmeticOperator() {
			for(int i = 0; i<100; i++) {
				int random = (int)(Math.random()*100);
				char ArithmeticOps[] = {'+','-','*','/','%','+','-','*','/','%'};
				arithmeticMutantArray[i] = ArithmeticOps[mutantArray[random]];
			}
		}
		
		//Generates Random Numbers Corresponding to Operators
		
		void generateMutants() {
			for (int i=0; i<100; i++) {
				
				int random = (int)(Math.random()*10);
				
				mutantArray[i] =  random;
			}
		}
		
		String showArrayGenerated() {
			String nums = "";
			for (int i=0; i<mutantArray.length; i++) {
				nums += Integer.toString(mutantArray[i]) + ", ";
			}
			return nums;
		}
		/*
			im not sure why this was removed, but I believe it needs to be somewhere. 
			I suppose we could just have it as a string variable held in the collection 
			of mutations for each mutant, but we should discuss those options before removing.
			-Mike
		*/
		static class Mutation{
			String mutOperator; 
			
			Mutation(String mutOperator)
			{
				this.mutOperator = "";
				this.mutOperator = mutOperator;
			}
		
		}
		
	}