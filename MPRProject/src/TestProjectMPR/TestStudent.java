package TestProjectMPR;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Student;

public class TestStudent {

	private Student Test = new Student(1, "name", "surname");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStudent() {
		assertTrue(Test.getName().equals("name"));
		assertSame(Test.getID_number(), 1);
		assertEquals(Test.getSurname(), "surname");
	}

	@Test
	public void testGetID_number() {
		assertSame(Test.getID_number(), 1);
	}

	@Test
	public void testSetID_number() {
		Test.setID_number(2);
		
		assertTrue(Test.getID_number().equals(2));
	}

	@Test
	public void testGetName() {
		assertTrue(Test.getName().equals("name"));
	}

	@Test
	public void testSetName() {
		Test.setName("name_test");
		
		assertEquals(Test.getName(), "name_test");
	}

	@Test
	public void testGetSurname() {
		assertEquals(Test.getSurname(), "surname");
	}

	@Test
	public void testSetSurname() {
		Test.setSurname("surname_test");
		
		assertSame(Test.getSurname(), "surname_test");
	}

}
