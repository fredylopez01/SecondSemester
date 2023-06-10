package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import co.edu.uptc.model.Calculator;

public class CalculatorTest {
	private static Calculator calculator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		calculator = new Calculator();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	
	@Test
	public void testAdd() {
		int real = 7;
		int actual = calculator.add(4, 3);
		assertEquals(real, actual);
	}

	@Test
	public void testSubstraction() {
		int real = calculator.substraction(4, 9);
		int actual = calculator.substraction(9, 4);
		assertNotEquals(real, actual);
	}

	@Test
	public void testMultiplicar() {
		int real = calculator.multiplicar(5, 3);
		int actual = calculator.multiplicar(3, 5);
		assertEquals(real, actual);
	}

	@Test
	public void testDividir() {
		double real = 2;
		double actual = calculator.dividir(8, 4);
		assertEquals(real, actual, 0.1);
		assertTrue(true);
	}
	
	@Test
	public void testObject(){
		assertNotNull(calculator);
	}

}
