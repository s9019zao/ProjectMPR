package ProjectMPR;

public class Subiect {
	
	private int ID_subiect;
	private String Name;
	
	public Subiect(int iD_subiect, String name) {
		
		this.ID_subiect = iD_subiect;
		this.Name = name;
	}
	
	public Subiect() {	
	}

	public Integer getID_subiect() {
		return ID_subiect;
	}

	public void setID_subiect(int iD_subiect) {
		ID_subiect = iD_subiect;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public void printSubiect()
	{
		System.out.println("ID Subiect: " + ID_subiect +" |Name Subiect: " + Name);
	}
	
}
