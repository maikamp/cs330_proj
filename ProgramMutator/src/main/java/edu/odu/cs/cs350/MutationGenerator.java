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
<<<<<<< HEAD




	
	int id;
	int mutantArray[]; 
	
	for (int i=0; i<100; i++) {
		
		int random = (int)(Math.random()*10);
		mutantArray[i]=  random;
		System.out.print("Mutant ID: " + random);
		/// Basic array to generate mutant IDs ranging from 1-10000o
	}
	
	
=======
	static class Mutation{
		String mutOperator; //we could also use an int to identify the type of change made, e.g. the mutation -Mike
		
		Mutation(String mutOperator)
		{
			this.mutOperator = mutOperator;
		}
		
	}
>>>>>>> branch 'master' of git@forge350.cs.odu.edu:bdemerch/phase-2-4.git
}
