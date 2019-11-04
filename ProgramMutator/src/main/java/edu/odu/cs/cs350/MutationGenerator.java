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
	static class Mutation{
		String mutOperator; //we could also use an int to identify the type of change made, e.g. the mutation -Mike
		
		Mutation(String mutOperator)
		{
			this.mutOperator = mutOperator;
		}
		
	}
}
