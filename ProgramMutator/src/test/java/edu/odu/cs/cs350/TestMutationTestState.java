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

public class TestMutationTestState {
	
	private MutationTestState x;
	
	
	@Before
	public void setUp()
	{
		
	}
	
	@Test
	public void testConstructor()
	{
		
		
	}
	
	@Test
	public void testKillMutant()
	{
		boolean ans = false; 
		x = killMutant(m);
		assertThat(m.setAlive(ans), is(dead.add(m)));
		assertThat(m.setAlive(ans), is(alive.remove(m)));
	}
}
