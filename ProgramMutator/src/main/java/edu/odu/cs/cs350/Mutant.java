/**
 * Author: Mike Campbell <mcampbel>
 * ODU - CS350 - Fall 2019
 */

package edu.odu.cs.cs350;
import java.util.*;

class Mutant {
	/**
	id: int
	mutations: Collection
	getChanges() -> Collection
	Description of mutant <- mutant.tostring()
	**/
	int id;
	boolean alive;
	List<MutationOperator> mutations; //collection of mutationOperators applied to this mutant
	
	Mutant() //create blank mutant
	{
		this.id = 0;
		this.alive = true; 
		this.mutations = new ArrayList<MutationOperator> ();
	}
	
	Mutant(int id, boolean status, List<MutationOperator> mutationList) //create mutant with parameters
	{
		this.id = id;
		this.alive = status;
		this.mutations = new ArrayList<MutationOperator> (mutationList);
	}
	
	void setId(int newId)
	{
		this.id = newId;
	}
	
	void setAlive(boolean newStatus)
	{
		this.alive = newStatus;
	}
	
	void addMutations(List<MutationOperator> newMutList)
	{
		this.mutations = newMutList;
	}
	
	int getId()
	{
		return this.id;
	}
	
	boolean isAlive()
	{
		return this.alive;
	}
	
	// accessor for mutations, returns list of mutations as string
	// maybe returning the list itself is preferable with <Mutation> List<MutationGenerator.Mutation> as the type
	List<MutationOperator> getMutations() {
		
		return this.mutations;
	}
	
	//@Override
	public String toString() //returns a formatted string of the mutant's attributes
	{
		String isAlive;
		if (this.isAlive())
		{
			isAlive = new String("live");
		}
		else
		{
			isAlive = new String("dead");
		}
		return ("Mutant ID: " + this.getId() + "\nMutant Status: " + isAlive + 
				"\nMutations: " + this.getMutations());
	}
	 
}
