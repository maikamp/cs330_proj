/**
 * Author: Mike Campbell <mcampbel>
 * ODU - CS350 - Fall 2019
 */
package edu.odu.cs.cs350;

import java.util.*;

class MutationTestState {
	/**
	 * alive: Collection
		dead: Collection
		entirePool: Collection
		killMutant(Mutant m)
		getLiveMutants() -> toString(Collection)
		getSuccessRate() -> Value
	 */
	
	List<Mutant> alive;
	List<Mutant> dead;
	List<Mutant> allMutants;
	
	MutationTestState(List<Mutant> alive, List<Mutant> dead, List<Mutant> allMutants)
	{
		this.alive = new ArrayList<Mutant> ();
		this.dead = new ArrayList<Mutant> ();
		this.allMutants = new ArrayList<Mutant> ();
	}
	
	void killMutant(Mutant m)
	{
		m.setStatus("dead");
	}
	
	void getLiveMutants()
	{
		for(Mutant currentMutant : this.alive)
		{
			System.out.println(currentMutant.toString());
		}
	}
	void getSuccessRate()
	{
		int liveMuts = this.alive.size();
		int allMuts = this.allMutants.size();
		double rate = 1 - (liveMuts/allMuts);
		System.out.println("Success Rate:\n" + liveMuts + " of " + allMuts + " are still alive."
				+ "\nThe given tests only successfully removed " + rate + "% of the viable mutants.");
	}
}
