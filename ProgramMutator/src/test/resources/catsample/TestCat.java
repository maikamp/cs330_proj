package catsample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCat{
		
		Cat theCat;
		
	    @Before
	    public void setUp()
	    {
	        theCat = new Cat();
	    }
	    
	    @Test
	    public void testMeow() {
            assertEquals(theCat.meow(), "meow");
        }
	    
	    @Test
	    public void testCatolympics() {
	    	assertEquals(theCat.catolympics(), "run run run CRASH");
	    }
	    
	    @Test
	    public void testPurr() {
	    	assertEquals(theCat.purr(), "prrrrrr");
	    }
	    
	    @Test
	    public void testHookSocks() {
	    	assertEquals(theCat.hookSocks(), "TZING");
	    }
	    
	    @Test
	    public void failTest() {
	    	fail("cat.exe has stopped.");
	    }
	    
}