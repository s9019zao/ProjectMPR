package ProjectMPR;

public class Student {
	
	private int ID_number;
	private String Name;
	private String Surname;

	
	public Student(int iD_number, String name, String surname) {
		this.ID_number = iD_number;
		this.Name = name;
		this.Surname = surname;
		
	}

	public Integer getID_number() {
		return ID_number;
	}

	public void setID_number(int iD_number) {
		ID_number = iD_number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public void printStudent()
	{
		System.out.println("ID Student: "+ID_number+" |Name Student: "+ Name + " " + Surname);
	}
	
	

}
