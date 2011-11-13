package ProjectMPR;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		List<Student> students= new ArrayList<Student>();

		List<Subiect> subiects= new ArrayList<Subiect>();		
		
		Studies Studies1=new Studies("Studies1", students, subiects);
		
		Studies1.addStudent(1 , "Jan Kowalski");
		Studies1.addStudent(2 , "Bogdan Tomczyk");
		Studies1.addStudent(3 , "Roman Wisniewski");
		
		Studies1.addSubiect( 1 ,"Subiect1");
		Studies1.addSubiect( 10 ,"Subiect2");
		Studies1.addSubiect( 11 ,"Subiect3");
		
		Studies1.printSubiects();
		Studies1.printStudents();
		
		Studies1.removeStudent("Bogdan Tomczyk");
		Studies1.removeSubiect("Subiect3");
		Studies1.editStudent_Name_idnumber(3, "Roman Wisniewski", 12, "Henryk Apostol");
		Studies1.editSubiect_Name_id(1, "Subiect1", 15, "Subiect4");

		Studies1.printAll();
	}	
}

