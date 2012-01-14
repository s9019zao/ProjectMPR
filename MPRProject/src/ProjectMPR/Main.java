package ProjectMPR;

import java.util.ArrayList;
import java.util.List;

import EventsProjectMPR.ChangeProgramme;
import EventsProjectMPR.Deanery;
import EventsProjectMPR.SubiectProcesses;
import ServicesProjectMPR.StudiesDBMenager;
import ServicesProjectMPR.StudentDBMenager;
import ServicesProjectMPR.SubiectDBMenager;
import ServicesProjectMPR.StudentSubiectDBMenager;
public class Main {

	
	public static void main(String[] args) {
		
		List<Student> students= new ArrayList<Student>();

		List<Subiect> subiects= new ArrayList<Subiect>();		
		
		Studies Studies1 = new Studies("Studies1", students, subiects);
		
		try {
			Studies1.addStudent(1 , "Jan", "Kowalski");
			Studies1.addStudent(2 , "Bogdan", "Tomczyk");
			Studies1.addStudent(3 , "Roman", "Wisniewski");
			Studies1.addStudent(4, "Jakub", "Wisniewski");
//			Działanie wyjątku
//			Studies1.addStudent(-4, "Jakub", "Wyjątek");
		} catch (IndeksException e) {
			e.printStackTrace();
		}
		
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
		
//-------------------------EVENTS--------------------
		
		System.out.println("----------------EVENTS---------------");

		Deanery deanery = new Deanery();
		SubiectProcesses changeprogramme = new ChangeProgramme();
		Subiect biologia = new Subiect();
		
		deanery.addProcessSubiect(changeprogramme);
		deanery.setSubiect(biologia);
		deanery.processSubiect();
		
//-------------------------DB-----------------------
		
		System.out.println("------------------DB-----------------");
		StudiesDBMenager StudiesDB= new StudiesDBMenager();
		StudiesDB.deleteAllStudies();
		
		Studies Studies2 = new Studies("Chemia", students, subiects);
		StudiesDB.addStudies(Studies2);
		Studies Studies3 = new Studies("Fizyka", students, subiects);
		StudiesDB.addStudies(Studies3);

		for(Studies studies: StudiesDB.getAllStudies()){
		System.out.println(studies.getName());
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
			System.out.println(student.getID_number()+" "+ student.getName()+ " "+ student.getSurname());
			}
		/* Usuwanie studenta z listy
		StudentDB.deleteStudent(StudentDB.findStudentBySurname("Kowalski"));
		for(Student student: StudentDB.getAllStudent()){
			System.out.println(student.getID_number()+" "+ student.getName()+ " "+ student.getSurname());
			}
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
			System.out.println(subiect.getID_subiect() + " " + subiect.getName());
			}
		/*Usuwanie subiect z listy
		SubiectDB.deleteSubiect(SubiectDB.findSubiectByName("Biochemia"));
		for(Subiect subiect: SubiectDB.getAllSubiect()){
			System.out.println(subiect.getID_subiect() + " " + subiect.getName());
			}
		*/
	
		StudentSubiectDBMenager StudentSubiectDB = new StudentSubiectDBMenager();
				
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentBySurname("Kowalski"), SubiectDB.findSubiectByName("Biochemia"));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentBySurname("Kowalski"), SubiectDB.findSubiectByName("Spektroskopia"));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentBySurname("Tomczyk"), SubiectDB.findSubiectByName("Krystlochemia"));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentBySurname("Tomczyk"), SubiectDB.findSubiectByName("Spektroskopia"));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentByIndeks(3), SubiectDB.findSubiectBySubiect_nr(11));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentByIndeks(3), SubiectDB.findSubiectBySubiect_nr(12));
		StudentSubiectDB.addSubiectToStudent(StudentDB.findStudentByIndeks(3), SubiectDB.findSubiectBySubiect_nr(13));

		System.out.println("List of Subiect Kowalski");
		for (Subiect subiect : StudentSubiectDB.getStudentSubiect(StudentDB.findStudentBySurname("Kowalski"))){
			System.out.println("Subiect_nr: " + subiect.getID_subiect() + " Name: "+subiect.getName());
			}
		
		System.out.println("List of Subiect Tomczyk");
		for (Subiect subiect : StudentSubiectDB.getStudentSubiect(StudentDB.findStudentBySurname("Tomczyk"))){
			System.out.println("Subiect_nr: " + subiect.getID_subiect() + " Name: "+subiect.getName());
			}
		
		System.out.println("List of Subiect Wisniewski");
		for (Subiect subiect : StudentSubiectDB.getStudentSubiect(StudentDB.findStudentBySurname("Wisniewski"))){
			System.out.println("Subiect_nr: " + subiect.getID_subiect() + " Name: "+subiect.getName());
			}
		
		StudentSubiectDB.deleteAllSubiectFromStudent (StudentDB.findStudentBySurname("Tomczyk"));
		
		System.out.println("List of Subiect Tomczyk");
		for (Subiect subiect : StudentSubiectDB.getStudentSubiect(StudentDB.findStudentBySurname("Tomczyk"))){
			System.out.println("Subiect_nr: " + subiect.getID_subiect() + " Name: "+subiect.getName());
			}
		
		
		StudentSubiectDB.deleteAllStudentSubiect();
		
	}	
}
