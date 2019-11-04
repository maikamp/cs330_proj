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
		//change mutant status to dead
	}
	
	void getLiveMutants()
	{
		//print list of live mutants
	}
	void getSuccessRate()
	{
		//print % = dead/allMutants
	}
}
