package edu.odu.cs.cs350;
import java.util.*;

<<<<<<< HEAD
class MutationGenerator(MutationOperator mop, GoldCode g) {
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

 Mutant mutantGenerator = new Mutant(); ///here it is not recognizing class mutant 

	int id;
	String status;
	boolean viable;

	for (int i=0; i<100; i++) {
		
		int r = (int)(Math.random()*100);
		mutantGenerator.setID(r); ///set mutant ID
		
			mutantGenerator.setStatus("alive"); /// set status 
			
			if(mutantGenerator.viable=true) {
				
			}else 
				
				
				
			
			}
	
			
			
			
		
			
		
			

		
	}
	



	
	
	/* int id;
	int mutantArray[]; 
	
	for (int i=0; i<100; i++) {
=======
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
>>>>>>> branch 'master' of git@forge350.cs.odu.edu:bdemerch/phase-2-4.git
		
<<<<<<< HEAD
		int random = (int)(Math.random()*10);
		mutantArray[i]=  random;
		System.out.print("Mutant ID: " + random);
		/// Basic array to generate mutant IDs ranging from 1-10000o
	 /* }
	
	
=======
	static class Mutation{
		String mutOperator; //we could also use an int to identify the type of change made, e.g. the mutation -Mike
		
		Mutation(String mutOperator)
		{
			this.mutOperator = mutOperator;
=======
		MutationGenerator(){
			generateMutants();
>>>>>>> branch 'master' of git@forge350.cs.odu.edu:bdemerch/phase-2-4.git
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