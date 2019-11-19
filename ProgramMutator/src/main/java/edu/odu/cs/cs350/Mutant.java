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
	String status;
	boolean viable; //may be unnecessary if we discard non-viable mutants upon generation
	List<MutationGenerator.Mutation> mutationList; //collection of mutations applied to this mutant
	
	Mutant()
	{
		this.id = 0;
		this.status = "live";
		this.viable = true;
		this.mutationList = new ArrayList<MutationGenerator.Mutation> ();
	}
	
	Mutant(int id, String status, boolean viable, List<MutationGenerator.Mutation> mutationList)
	{
		this.id = id;
		this.status = status;
		this.viable = viable;
		this.mutationList = new ArrayList<MutationGenerator.Mutation> (mutationList);
	}
	void setId(int newId)
	{
		
	}
	
	void setStatus(String newStatus)
	{
		
	}
	
	void setViable(boolean newViable)
	{
		
	}
	
	void addMutations(List<MutationGenerator.Mutation> newMutList)
	{
		
	}
	
	int getId()
	{
		return this.id;
	}
	
	String getStatus() 
	{
		return this.status;
	}
	
	boolean getViability()
	{
		return this.viable;
	}
	
	// accessor for mutationList, returns list of mutations as string
	// maybe returning the list itself is preferable with <Mutation> List<MutationGenerator.Mutation> as the type
	String getMutations() {
		
		return this.mutationList.toString();
	}
	
	//@Override
	public String toString()
	{
		return ("Mutant ID: " + this.getId() + "\nMutant Status: " + this.getStatus() + 
				"\nMutant Viability: " + this.getViability() + "\nMutations: " + this.getMutations());
	}
	 
}
