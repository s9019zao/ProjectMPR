package ProjectMPR;

import java.util.ArrayList;
import java.util.List;

import ServicesProjectMPR.StudiesDBMenager;

public class Main {

	
	public static void main(String[] args) {
		
		List<Student> students= new ArrayList<Student>();

		List<Subiect> subiects= new ArrayList<Subiect>();		
		
		Studies Studies1 = new Studies("Studies7", students, subiects);
		
		Studies1.addStudent(1 , "Jan", "Kowalski");
		Studies1.addStudent(2 , "Bogdan", "Tomczyk");
		Studies1.addStudent(3 , "Roman", "Wisniewski");
		Studies1.addStudent(4, "Jakub", "Wisniewski");
		
		Studies1.addSubiect( 1 ,"Subiect1");
		Studies1.addSubiect( 10 ,"Subiect2");
		Studies1.addSubiect( 11 ,"Subiect3");
		
		Studies1.printSubiects();
		Studies1.printStudents();
		System.out.println("----------------");
		Studies1.printStudent_by_surname(Studies1.searchStudent("Kowalski"));
		Studies1.editManyStudent_Surname(Studies1.searchStudent("Wisniewski"), "Wiśniewski");
		
		Studies1.removeStudent("Tomczyk");
		Studies1.removeSubiect("Subiect3");
		Studies1.editStudent(1 , "Jan", "Kowalski", 12, "Henryk", "Apostol");
		Studies1.editSubiect(1, "Subiect1", 15, "Subiect4");

		Studies1.printAll();
		
		StudiesDBMenager db= new StudiesDBMenager();
		db.addStudies(Studies1);

		for(Studies s: db.getAllStudies())
		{
		System.out.println(s);
		}
	}	
}

