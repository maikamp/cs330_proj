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
		
		MutationGenerator(){
			generateMutants();
		}
		
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
	}