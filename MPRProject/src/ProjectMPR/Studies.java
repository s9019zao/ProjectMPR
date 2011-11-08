package ProjectMPR;

import java.util.ArrayList;
import java.util.List;

public class Studies {
	
	private String Name;
	private List<Student> students= new ArrayList<Student>();
	private List<Subiect> subiects= new ArrayList<Subiect>();
	
	
	public Studies(String name, List<Student> students, List<Subiect> subiects) {
		
		this.Name = name;
		this.students = students;
		this.subiects = subiects;
	}
			
	public Studies(String name) {
		super();
		this.Name = name;
		this.students = new ArrayList<Student>();
		this.subiects = new ArrayList<Subiect>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

    public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Subiect> getSubiects() {
		return subiects;
	}

	public void setSubiects(List<Subiect> subiects) {
		this.subiects = subiects;
	}
	
	public void removeStudent(String name) {
		int position = 0;
		for (Student student : students) {
			if (student.getName().equals(name)) {
				students.remove(position);
				break;
			}
			position++;
		}
	}
	
	public void removeSubiect(String name) {
		int position = 0;
		for (Subiect subiect : subiects) {
			if (subiect.getName().equals(name)) {
				subiects.remove(position);
				break;
			}
			position++;
		}
	}

	public void addStudent (int iD_number, String name){
		students.add(new Student(iD_number, name));
		
	}
	
	public void addSubiect (int iD_subiect, String name){
		subiects.add(new Subiect(iD_subiect, name));
		
	}
	
	public void searchStudent(String name) {
		
		System.out.println("Search Student:");
		for (Student student : students) {
			if (student.getName().equals(name))
			student.printStudent();
		}
		
	}
	
	public void searchSubiect(String name){ 
		
		System.out.println("Search Subiects:");
		for (Subiect subiect : subiects) {
			if (subiect.getName().equals(name))
				subiect.printSubiect();
		}
	}

	public void printStudents(){
		
		System.out.println("List of Students:");
		for(Student student: students){
			student.printStudent();
		}
	}
	
	public void editStudent_Name(int id_number, String new_name) {
		int position = 0;
		for (Student student : students) {
			if (student.getID_number().equals(id_number)) {
				students.set(position, new Student(id_number, new_name));
				break;
			}
			position++;
		}
	}
	
	public void editStudent_Number(int new_id_number, String name) {
		int position = 0;
		for (Student student : students) {
			if (student.getName().equals(name)) {
				students.set(position, new Student(new_id_number, name));
				break;
			}
			position++;
		}
	}
	
	public void editSubiect_Name(int id_subiect, String new_name) {
		int position = 0;
		for (Subiect subiect : subiects) {
			if (subiect.getID_subiect().equals(id_subiect)) {
				subiects.set(position, new Subiect(id_subiect, new_name));
				break;
			}
			position++;
		}
	}
	
	public void editSubiect_Number(int new_id_subiect, String name) {
		int position = 0;
		for (Subiect subiect : subiects) {
			if (subiect.getName().equals(name)) {
				subiects.set(position, new Subiect(new_id_subiect, name));
				break;
			}
			position++;
		}
	}
	
	public void printSubiects(){
		
		System.out.println("List of Subiects:");
		for(Subiect subiect: subiects){
			subiect.printSubiect();
		}
	}
	
	public void printAll(){
		
		System.out.println("List of Students:");
		
		for(Student student: students){
			student.printStudent();
		}
		
		System.out.println("List of Subiects:");
		
		for(Subiect subiect: subiects){
			subiect.printSubiect();
		}
	}
	
}