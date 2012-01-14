package TestProjectMPR;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Studies;
import ServicesProjectMPR.StudiesDBMenager;

public class TestStudiesDBMenager {
	
	StudiesDBMenager TestStudiesDB= new StudiesDBMenager();

	@Before
	public void setUp() throws Exception {
		TestStudiesDB.addStudies(new Studies("name_1"));
		TestStudiesDB.addStudies(new Studies("name_2"));
		TestStudiesDB.addStudies(new Studies("name_2"));
	}

	@After
	public void tearDown() throws Exception {
		TestStudiesDB.deleteAllStudies();
	}

	@Test
	public void testFindStudiesByName() {
		assertNotNull(TestStudiesDB.findStudiesByName("name_1"));
		assertEquals(2, TestStudiesDB.findStudiesByName("name_2").size());
	}

	@Test
	public void testAddStudies() {
		assertEquals(3, TestStudiesDB.getAllStudies().size());
		TestStudiesDB.addStudies(new Studies("name_3"));
		assertEquals(4, TestStudiesDB.getAllStudies().size());
	}

	@Test
	public void testGetAllStudies() {
		assertEquals(3, TestStudiesDB.getAllStudies().size());
	}

	@Test
	public void testDeleteStudies() {
		assertTrue(TestStudiesDB.getAllStudies().size()==3);
		TestStudiesDB.deleteStudies(TestStudiesDB.findStudiesByName("name_1"));
		assertTrue(TestStudiesDB.getAllStudies().size()==2);
		assertEquals(0, TestStudiesDB.findStudiesByName("name_1").size());
	}

	@Test
	public void testDeleteAllStudies() {
		assertEquals(3, TestStudiesDB.getAllStudies().size());
		TestStudiesDB.deleteAllStudies();
		assertTrue(TestStudiesDB.getAllStudies().size()==0);
	}

}
