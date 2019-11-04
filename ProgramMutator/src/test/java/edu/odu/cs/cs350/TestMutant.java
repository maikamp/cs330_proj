/**
 * Author: Mike Campbell <mcampbel>
 * ODU - CS350 - Fall 2019
 */
package edu.odu.cs.cs350;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

public class TestMutant {
	
	Mutant testDefaultMutant;
	Mutant testInputValuesMutant;
	List<MutationGenerator.Mutation> mList0 = new ArrayList<MutationGenerator.Mutation>();
	List<MutationGenerator.Mutation> mList1 = new ArrayList<MutationGenerator.Mutation>();
	
	@Before
	public void setUp()
	{
		testDefaultMutant = new Mutant();
		testInputValuesMutant = new Mutant(25, "dead", false, mList0);
	}
	
	@Test
	public void testDefaultMutantConstructor()
	{
		assertThat(testDefaultMutant.id, is(0));
		assertThat(testDefaultMutant.status, is("live"));
		assertThat(testDefaultMutant.viable, is(true));
		//assertThat(testDefaultMutant.mutationList, is(something));
	}
	
	@Test
	public void testInputValuesMutantConstructor()
	{
		assertThat(testInputValuesMutant.id, is(25));
		assertThat(testInputValuesMutant.status, is("dead"));
		assertThat(testInputValuesMutant.viable, is(false));
		//assertThat(testInputValuesMutant.mutationList, is(something));
	}
	
	@Test
	public void testSetID()
	{
		testDefaultMutant.setId(2);
		assertThat(testDefaultMutant.id, is(2));
		
		testInputValuesMutant.setId(3);
		assertThat(testInputValuesMutant.id, is(3));
	}
	
	@Test
	public void testSetStatus()
	{
		testDefaultMutant.setStatus("dead");
		assertThat(testDefaultMutant.status, is("dead"));
		
		testInputValuesMutant.setStatus("live");
		assertThat(testInputValuesMutant.status, is("live"));
	}
	
	@Test
	public void testSetViable()
	{
		testDefaultMutant.setViable(false);
		assertThat(testDefaultMutant.viable, is(false));
		
		testInputValuesMutant.setViable(true);
		assertThat(testInputValuesMutant.viable, is(true));
	}
	
	@Test
	public void testAddMutations()
	{
		testDefaultMutant.addMutations(mList1);
		assertThat(testDefaultMutant.mutationList, is(mList1));
		
		testInputValuesMutant.addMutations(mList1);
		assertThat(testInputValuesMutant.mutationList, is(mList1));
	}
}
