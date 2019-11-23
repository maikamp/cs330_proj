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
	List<MutationOperator> mList0 = new ArrayList<MutationOperator>();
	List<MutationOperator> mList1 = new ArrayList<MutationOperator>();
	
	@Before
	public void setUp()
	{
		testDefaultMutant = new Mutant();
		testInputValuesMutant = new Mutant(25, false, mList0);
	}
	
	@Test
	public void testDefaultMutantConstructor()
	{
		assertThat(testDefaultMutant.id, is(0));
		assertThat(testDefaultMutant.alive, is("live"));
		//assertThat(testDefaultMutant.mutationList, is(something));
	}
	
	@Test
	public void testInputValuesMutantConstructor()
	{
		assertThat(testInputValuesMutant.id, is(25));
		assertThat(testInputValuesMutant.alive, is("dead"));
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
		testDefaultMutant.setAlive(false);
		assertThat(testDefaultMutant.alive, is("dead"));
		
		testInputValuesMutant.setAlive(true);
		assertThat(testInputValuesMutant.alive, is("live"));
	}

	@Test
	public void testAddMutations()
	{
		testDefaultMutant.addMutations(mList1);
		assertThat(testDefaultMutant.mutations, is(mList1));
		
		testInputValuesMutant.addMutations(mList1);
		assertThat(testInputValuesMutant.mutations, is(mList1));
	}
}
