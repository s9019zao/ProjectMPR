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

	public void addStudent (int iD_number, String name){
		students.add(new Student(iD_number, name));
		
	}
	
	public void addSubiect (int iD_subiect, String name){
		subiects.add(new Subiect(iD_subiect, name));
		
	}
	
	public void removeStudent(String name) {
		students.remove(searchStudent(name));
	}
	
	public void removeSubiect(String name) {
		subiects.remove(searchSubiect(name));
	}
	
	public Student searchStudent(String name) {
	
		for (Student student : students) {
			if (student.getName().equals(name))
			return student;
		}
		return null;
	}
	
	public Subiect searchSubiect(String name){ 
		
		for (Subiect subiect : subiects) {
			if (subiect.getName().equals(name))
				return subiect;
		}
		return null;
	}

	
	public void editStudent_Name_idnumber(int id_number, String name, int new_id_number, String new_name) {
		students.set(students.indexOf(searchStudent(name)), new Student(new_id_number, new_name));
	}
	
	public void editSubiect_Name_id(int id_subiect,  String name, int new_id_subiect, String new_name) {
		subiects.set(subiects.indexOf(searchSubiect(name)), new Subiect(new_id_subiect, new_name));
	}
	
	
	public void printSubiects(){
		
		System.out.println("List of Subiects:");
		for(Subiect subiect: subiects){
			subiect.printSubiect();
		}
	}

	public void printStudents(){
		
		System.out.println("List of Students:");
		for(Student student: students){
			student.printStudent();
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