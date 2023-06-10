package co.edu.uptc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.uptc.model.Enterprise;
import co.edu.uptc.model.ExceptionEquals;
import co.edu.uptc.model.ExceptionEqualsCapacity;
import co.edu.uptc.model.Truck;

public class EnterpriseTest {
	private static Enterprise enterprise;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		enterprise = new Enterprise(5);
		Truck one =new Truck("hyw", 1300, 8);
		Truck two =new Truck("jsw", 1300, 7);
		try {
			enterprise.addTruck(one);
			enterprise.addTruck(two);
			enterprise.addTruck(two);
		} catch(ExceptionEquals e){
			System.out.println(e.getMessage());
		}
		
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
	public void testMaxCapacity() {
		String real = "hyw";
		try {
			String actual = enterprise.maxCapacity();
			assertEquals(real, actual);
		} catch(ExceptionEqualsCapacity e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void testTotalCapacity() {
		int real = 120;
		int actual = enterprise.totalCapacity();
		assertNotEquals(real, actual);
	}

	@Test
	public void testAvgConsumption() {
		double real = 7.5;
		double actual = enterprise.avgConsumption();
		assertEquals(real, actual, 0.1);
	}

	@Test
	public void testAddTruck() {
		Truck three = new Truck("asv789", 290, 10);
		try {
			assertTrue(enterprise.addTruck(three));
			assertThrows(ExceptionEquals.class, ()-> enterprise.addTruck(three));
		} catch(ExceptionEquals e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testSearchTruck() {
		String plate = "gsh372";
		assertFalse(enterprise.searchTruck(plate));
	}
}
