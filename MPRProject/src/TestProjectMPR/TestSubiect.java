package TestProjectMPR;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Subiect;

public class TestSubiect {

	private Subiect Test = new Subiect(1, "Test");
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubiect() {
		assertTrue(Test.getName().equals("Test"));
		assertSame(Test.getID_subiect(), 1);
	}

	@Test
	public void testGetID_subiect() {
		assertTrue(Test.getID_subiect()==1);
	}

	@Test
	public void testSetID_subiect() {
		Test.setID_subiect(2);
		
		assertSame(2, Test.getID_subiect());
	}

	@Test
	public void testGetName() {
		assertTrue(Test.getName().equals("Test"));
	}

	@Test
	public void testSetName() {
		Test.setName("Test_1");
		
		assertSame("Test_1", Test.getName());
	}

}
