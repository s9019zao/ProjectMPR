package TestProjectMPR;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Student;
import ServicesProjectMPR.StudentDBMenager;

public class TestStudentDBMenager {
		
	StudentDBMenager TestStudentDB= new StudentDBMenager();
	
	@Before
	public void setUp() throws Exception {
		TestStudentDB.addDBStudent(new Student(1, "name_1", "surname_1"));
		TestStudentDB.addDBStudent(new Student(2, "name_2", "surname_1"));
		TestStudentDB.addDBStudent(new Student(3, "name_3", "surname_3"));
	}

	@After
	public void tearDown() throws Exception {
		TestStudentDB.deleteAllStudent();
	}

	@Test
	public void testAddDBStudent() {
		assertEquals(3, TestStudentDB.getAllStudent().size());
		TestStudentDB.addDBStudent(new Student(4, "name_4", "surname_4"));
		assertTrue(TestStudentDB.getAllStudent().size()==4);
	}

	@Test
	public void testGetAllStudent() {
		assertTrue(TestStudentDB.getAllStudent().size()==3);
	}

	@Test
	public void testDeleteAllStudent() {
		assertEquals(3, TestStudentDB.getAllStudent().size());
		TestStudentDB.deleteAllStudent();
		assertTrue(TestStudentDB.getAllStudent().size()==0);
	}

	@Test
	public void testFindStudentBySurname() {
		assertNotNull(TestStudentDB.findStudentBySurname("surname_1"));
		assertEquals(2, TestStudentDB.findStudentBySurname("surname_1").size());
	}

	@Test
	public void testFindStudentByIndeks() {
		assertTrue(TestStudentDB.findStudentByIndeks(2).size()==1);
		assertEquals(0, TestStudentDB.findStudentByIndeks(5).size());
	}

	@Test
	public void testDeleteStudent() {
		assertTrue(TestStudentDB.getAllStudent().size()==3);
		TestStudentDB.deleteStudent(TestStudentDB.findStudentBySurname("surname_3"));
		assertTrue(TestStudentDB.getAllStudent().size()==2);
		assertEquals(0, TestStudentDB.findStudentBySurname("surname_3").size());
	}

}
