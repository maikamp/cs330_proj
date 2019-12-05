package edu.odu.cs.cs350;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

public class TestMutationTestState {
	
	MutationTestState x;
	Mutant m1;
	Mutant m2;
	List<MutationOperator> muts;
	//MutationOperator mOp;
	
	@Before
	public void setUp()
	{
		x = new MutationTestState();
		m1 = new Mutant();
		m2 = new Mutant(2,false, muts);
		//mOp = new MutationOperator();
	}
	
	@Test
	public void testConstructor()
	{
<<<<<<< HEAD
		x = new MutationTestState();
		y = new MutationTestState();
		x.alive = new ArrayList<Mutant> a();
		y.alive = new ArrayList<Mutant> b();
		assertEquals(a,b);

=======

		//check that all the member arrays start empty
		assertThat(x.alive.size(),is(0));
		assertThat(x.dead.size(),is(0));
		assertThat(x.allMutants.size(),is(0));
		
		x.alive.add(m1);
		x.dead.add(m2);
		x.allMutants.add(m1);
		x.allMutants.add(m2);
		
		//check that the arrays are different now that alive added 2 elements
		assertThat(x.alive, is(not(x.dead)));
		
		//check the size of each array
		assertThat(x.alive.size(), is(1));
		assertThat(x.dead.size(), is(1));
		assertThat(x.allMutants.size(), is(2));
>>>>>>> branch 'master' of git@forge350.cs.odu.edu:bdemerch/phase-2-4.git
	}
	
	@Test
	public void testKillMutant()
	{
		x.killMutant(m2);
		assertThat(m2.isAlive(), is(false));
		assertTrue(x.dead.contains(m2));
		assertFalse(x.alive.contains(m2));
	}
	
}
