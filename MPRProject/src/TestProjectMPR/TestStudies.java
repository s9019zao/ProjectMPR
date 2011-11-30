package TestProjectMPR;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProjectMPR.Student;
import ProjectMPR.Subiect;
import ProjectMPR.Studies;

public class TestStudies {
	
	private List<Student> students= new ArrayList<Student>();
	private List<Subiect> subiects= new ArrayList<Subiect>();
	private Studies Test = new Studies("Test", students, subiects);

	
	@Before
	public void setUp() throws Exception {
	
	students.add(new Student(1 , "name", "surname"));
	students.add(new Student(2 , "name_1", "surname"));
	students.add(new Student(3 , "name_2", "surname_2"));
	subiects.add(new Subiect (1, "first"));
	subiects.add(new Subiect (2, "first_1"));
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testStudies() {
		assertTrue(Test.getName().equals("Test"));
		assertSame(Test.getStudents(), students);
		assertEquals(Test.getSubiects(), subiects);
	}

	@Test
	public void testGetName() {
		assertTrue(Test.getName().equals("Test"));
	}

	@Test
	public void testSetName() {
		Test.setName("Test_1");
		
		assertTrue(Test.getName().equals("Test_1"));
		assertSame("Test_1", Test.getName());
	}

	@Test
	public void testGetStudents() {
		assertTrue(Test.getStudents().equals(students));
	}

	@Test
	public void testSetStudents() {
		Test.setStudents(students);
		
		assertTrue(Test.getStudents().equals(students));
		assertEquals(Test.getStudents() , students);
	}

	@Test
	public void testGetSubiects() {
		assertTrue(Test.getSubiects().equals(subiects));
	}

	@Test
	public void testSetSubiects() {
		Test.setSubiects(subiects);
		
		assertSame(subiects, Test.getSubiects());
		assertEquals(Test.getStudents() , students);
	}

	@Test
	public void testAddStudent() {
		assertFalse(students.size() == 1);
		assertTrue(students.size() == 3);
	}

	@Test
	public void testAddSubiect() {
		assertTrue(subiects.size() == 2);
	}

	@Test
	public void testSearchStudent() {
		assertNotNull(Test.searchStudent("surname"));	
	}

	@Test
	public void testSearchSubiect() {
		assertNull(Test.searchSubiect("name"));
		assertNotNull(Test.searchSubiect("first"));
	}

	@Test
	public void testEditStudent() {
		Test.editStudent(1, "name", "surname", 2, "new_name", "surname");
		
		assertFalse(students.get(0).getName()=="name");
		assertTrue(students.get(0).getID_number()==2);
		assertSame("new_name", Test.searchStudent("surname").getName());
	}

	@Test
	public void testEditSubiect() {
		Test.editSubiect(1, "first", 2, "second");
		
		assertSame("second", Test.searchSubiect("second").getName());
		assertTrue(subiects.get(0).getName()=="second");
	}

	@Test
	public void testEditManyStudent_Surname() {
		Test.editManyStudent_Surname(Test.searchStudent("surname"), "new_surname");
		
		assertEquals(Test.searchStudent("new_surname").getSurname() , students.get(0).getSurname());
		assertTrue(students.get(1).getSurname()=="new_surname");
	}
	
	@Test
	public void testRemoveStudent() {
		Test.removeStudent("surname_2");
		
		assertTrue(students.size() == 2);
	}

	@Test
	public void testRemoveSubiect() {
		Test.removeSubiect("first_1");
		
		assertTrue(subiects.size() == 1);
	}

}
