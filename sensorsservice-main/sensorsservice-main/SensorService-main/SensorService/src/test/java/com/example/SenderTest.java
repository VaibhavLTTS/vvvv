package com.example;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SenderTest {
	@Autowired
Sender sender;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateBPRandom() {
		//fail("Not yet implemented");
		int actual=sender.generateBPRandom();
//		if(actual>=90&&actual<=140) {
//			System.out.println("Passed");
			assertTrue(actual>=90&&actual<=140);
		}
//		else
//			fail("Not yet implemented");
		//assertEquals(,actual);
	

	@Test
	public void testGenerateHeartRateRandom() {
		//fail("Not yet implemented");
		int actual=sender.generateHeartRateRandom();
//		if(actual>=60&&actual<=100) {
//			System.out.println("Passed");
//		}
//		else
//			fail("Not yet implemented");
		assertTrue(actual>=60&&actual<=100);
		
	}

	@Test
	public void testGenerateOLRandom() {
		//fail("Not yet implemented");
		int actual=sender.generateOLRandom();
//		if(actual>=75&&actual<=100) {
//			System.out.println("Passed");
//		}
//		else
//			fail("Not yet implemented");
//	}
		assertTrue(actual>=75&&actual<=100);

}
}
