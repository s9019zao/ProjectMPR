package ProjectMPR;

import java.util.ArrayList;
import java.util.List;

import ServicesProjectMPR.StudiesDBMenager;
import ServicesProjectMPR.StudentDBMenager;
import ServicesProjectMPR.SubiectDBMenager;

public class Main {

	
	public static void main(String[] args) {
		
		List<Student> students= new ArrayList<Student>();

		List<Subiect> subiects= new ArrayList<Subiect>();		
		
		Studies Studies1 = new Studies("Studies1", students, subiects);
		
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
		
//-------------------------DB------------------------		
		StudiesDBMenager StudiesDB= new StudiesDBMenager();
		StudiesDB.deleteAllStudies();
		
		Studies Studies2 = new Studies("Chemia", students, subiects);
		StudiesDB.addStudies(Studies2);

		for(Studies studies: StudiesDB.getAllStudies()){
		System.out.println(studies);
		}
		
		StudentDBMenager StudentDB= new StudentDBMenager();
		StudentDB.deleteAllStudent();
		
		Student s1 = new Student(1 , "Jan", "Kowalski");
		StudentDB.addDBStudent(s1);
		Student s2 = new Student(2 , "Bogdan", "Tomczyk");
		StudentDB.addDBStudent(s2);
		Student s3 = new Student(3 , "Roman", "Wisniewski");
		StudentDB.addDBStudent(s3);
		
		for(Student student: StudentDB.getAllStudent()){
			System.out.println(student);
			}
		/* Usuwanie studenta z listy
		StudentDB.deleteStudent(StudentDB.findStudentBySurname("Kowalski"));
		*/
		
		SubiectDBMenager SubiectDB= new SubiectDBMenager();
		SubiectDB.deleteAllSubiect();
		
		Subiect subiect1 = new Subiect(11, "Biochemia");
		SubiectDB.addDBSubiect(subiect1);
		Subiect subiect2 = new Subiect(12 , "Krystlochemia");
		SubiectDB.addDBSubiect(subiect2);
		Subiect subiect3 = new Subiect(13 , "Spektroskopia");
		SubiectDB.addDBSubiect(subiect3);
		
		for(Subiect subiect: SubiectDB.getAllSubiect()){
			System.out.println(subiect);
			}
		/* Usuwanie subiect z listy
		SubiectDB.deleteSubiect(SubiectDB.findSubiectByName("Biochemia"));
		*/
	
	}	
}
