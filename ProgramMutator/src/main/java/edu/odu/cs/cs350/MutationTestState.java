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
