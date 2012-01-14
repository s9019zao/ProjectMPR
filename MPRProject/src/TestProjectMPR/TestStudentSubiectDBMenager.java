package TestProjectMPR;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Student;
import ProjectMPR.Subiect;
import ServicesProjectMPR.StudentSubiectDBMenager;
import ServicesProjectMPR.StudentDBMenager;
import ServicesProjectMPR.SubiectDBMenager;

public class TestStudentSubiectDBMenager {
	StudentSubiectDBMenager TestStudentSubiectDB= new StudentSubiectDBMenager();
	StudentDBMenager TestStudentDB= new StudentDBMenager();
	SubiectDBMenager TestSubiectDB= new SubiectDBMenager();

	@Before
	public void setUp() throws Exception {
		TestStudentDB.addDBStudent(new Student(1, "name_1", "surname_1"));
		TestStudentDB.addDBStudent(new Student(2, "name_2", "surname_2"));
		TestSubiectDB.addDBSubiect(new Subiect(11, "subiect_1"));
		TestSubiectDB.addDBSubiect(new Subiect(12, "subiect_2"));
		TestStudentSubiectDB.addSubiectToStudent(TestStudentDB.findStudentBySurname("surname_1"), TestSubiectDB.findSubiectByName("subiect_1"));
		TestStudentSubiectDB.addSubiectToStudent(TestStudentDB.findStudentBySurname("surname_1"), TestSubiectDB.findSubiectByName("subiect_2"));
		TestStudentSubiectDB.addSubiectToStudent(TestStudentDB.findStudentBySurname("surname_2"), TestSubiectDB.findSubiectByName("subiect_1"));
	}

	@After
	public void tearDown() throws Exception {
		TestStudentSubiectDB.deleteAllStudentSubiect();
		TestSubiectDB.deleteAllSubiect();
		TestStudentDB.deleteAllStudent();
	}

	@Test
	public void testAddSubiectToStudent() {
		assertEquals(1, TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size());
		TestStudentSubiectDB.addSubiectToStudent(TestStudentDB.findStudentBySurname("surname_2"), TestSubiectDB.findSubiectByName("subiect_2"));
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size()==2);
	}

	@Test
	public void testGetStudentSubiect() {
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_1")).size()==2);
	}

	@Test
	public void testDeleteAllSubiectFromStudent() {
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_1")).size()==2);
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size()==1);
		TestStudentSubiectDB.deleteAllSubiectFromStudent(TestStudentDB.findStudentBySurname("surname_1"));
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_1")).size()==0);
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size()==1);	
	}

	@Test
	public void testDeleteAllStudentSubiect() {
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_1")).size()==2);
		assertEquals(1, TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size());
		TestStudentSubiectDB.deleteAllStudentSubiect();
		assertTrue(TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_2")).size()==0);
		assertEquals(0, TestStudentSubiectDB.getStudentSubiect(TestStudentDB.findStudentBySurname("surname_1")).size());
	}

}
