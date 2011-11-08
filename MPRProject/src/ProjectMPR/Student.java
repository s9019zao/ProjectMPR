package ProjectMPR;

public class Student {
	
	private int ID_number;
	private String Name;
	
	
	public Student(int iD_number, String name) {
		this.ID_number = iD_number;
		this.Name = name;
		
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

	
	
	public void printStudent()
	{
		System.out.println("ID Student: "+ID_number+" |Name Student: "+ Name);
	}
	
	

}
