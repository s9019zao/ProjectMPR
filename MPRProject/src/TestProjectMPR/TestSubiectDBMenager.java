package TestProjectMPR;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Subiect;
import ServicesProjectMPR.SubiectDBMenager;

public class TestSubiectDBMenager {
	
	SubiectDBMenager TestSubiectDB= new SubiectDBMenager();

	@Before
	public void setUp() throws Exception {
		TestSubiectDB.addDBSubiect(new Subiect(1, "name_1"));
		TestSubiectDB.addDBSubiect(new Subiect(2, "name_1"));
	}

	@After
	public void tearDown() throws Exception {
		TestSubiectDB.deleteAllSubiect();
	}

	@Test
	public void testAddDBSubiect() {
		assertEquals(2, TestSubiectDB.getAllSubiect().size());
		TestSubiectDB.addDBSubiect(new Subiect(3, "name_3"));
    	assertEquals(3, TestSubiectDB.getAllSubiect().size());
	}

	@Test
	public void testGetAllSubiect() {
		assertTrue(TestSubiectDB.getAllSubiect().size()==2);
	}

	@Test
	public void testDeleteAllSubiect() {
		assertEquals(2, TestSubiectDB.getAllSubiect().size());
		TestSubiectDB.deleteAllSubiect();
		assertTrue(TestSubiectDB.getAllSubiect().size()==0);
	}

	@Test
	public void testFindSubiectByName() {
		assertNotNull(TestSubiectDB.findSubiectByName("name_1"));
		assertEquals(2, TestSubiectDB.findSubiectByName("name_1").size());
	}

	@Test
	public void testFindSubiectBySubiect_nr() {
		assertTrue(TestSubiectDB.findSubiectBySubiect_nr(2).size()==1);
		assertEquals(0, TestSubiectDB.findSubiectBySubiect_nr(5).size());
	}

	@Test
	public void testDeleteSubiect() {
		assertTrue(TestSubiectDB.getAllSubiect().size()==2);
		TestSubiectDB.deleteSubiect(TestSubiectDB.findSubiectBySubiect_nr(1));
		assertTrue(TestSubiectDB.getAllSubiect().size()==1);
		assertEquals(1, TestSubiectDB.findSubiectByName("name_1").size());
	}

}
