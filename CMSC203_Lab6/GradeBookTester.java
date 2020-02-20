package dataElement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTester {
	private GradeBook g1, g2;
	


	
	@BeforeEach
	public void setUp() throws Exception{ 
		System.out.println("=setup");
		
		
		g1 = new GradeBook(5);
		g2 = new GradeBook(2);
		
		g1.addScore(80);
		g1.addScore(57);
		g1.addScore(84);
		g1.addScore(99);
		g1.addScore(82);
		g2.addScore(97);
		g2.addScore(33);
	}
	
	
	
	@AfterEach
	public void tearDwon() throws Exception{
		System.out.println("= teardown");
		
		g1 = null;
		g2 = null;
	}
	
	
	@Test
	public void testSum() {
		assertEquals(402, g1.sum());
		assertEquals(130, g2.sum());
	}
	
	@Test
	public void testMinimum() {
		assertEquals(57, g1.minimum());
		assertEquals(33, g2.minimum());
	}
	
	@Test
	public void addScoreTest(){
		assertTrue(g1.toString().equals("80.0 57.0 84.0 99.0 82.0"));
		assertTrue(g2.toString().equals("97.0 33.0"));
	}
	@Test
	public void finalScoreTest(){
		assertEquals(345, g1.finalScore());
		assertEquals(97, g2.finalScore());
	}
	
}