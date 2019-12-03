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
	
	MutationTestState()
	{
		this.alive = new ArrayList<Mutant> ();
		this.dead = new ArrayList<Mutant> ();
		this.allMutants = new ArrayList<Mutant> ();
	}
	Mutant getMutantByID(int mID)
	{
		int mIndex = 0;
		
		for(Mutant currentMutant : this.allMutants)
		{
			if (currentMutant.id == mID)
			{
				mIndex = allMutants.indexOf(currentMutant);
			}
		}
		
		return allMutants.get(mIndex);
	}
	
	void killMutant(Mutant m)
	{
		m.setAlive(false); 
		//add to dead collection
		if (dead.contains(m))
		{
			dead.add(m);
		}
		//remove from alive collection
		if (alive.contains(m))
		{
			alive.remove(m);
		}
	}
	
	void printLiveMutants()
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
