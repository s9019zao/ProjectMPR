package ServicesProjectMPR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProjectMPR.Subiect;

public class StudentSubiectDBMenager {
	
	private Connection conn;
	private Statement createTable;
	private PreparedStatement addSubiectToStudentStmt;
	private PreparedStatement getStudentSubiectStmt;
	private PreparedStatement deleteAllSubiectFromStudentStmt;
	private PreparedStatement deleteAllStudentSubiectStmt;
	public StudentSubiectDBMenager(){
		
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");		
			createTable = conn.createStatement();
			ResultSet rs=conn.getMetaData().getTables(null, null, null, null);
			boolean Subiect_To_StudentTableExists=false;
			while(rs.next()){
				if("Subiect_To_Student".equalsIgnoreCase(rs.getString("Table_Name"))){
					Subiect_To_StudentTableExists=true;
					break;
				}
			}
				if(!Subiect_To_StudentTableExists){
					createTable.executeUpdate("CREATE TABLE Subiect_To_Student(student_id int, subiect_id int, " +
					"CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES Student (id), " +
					"CONSTRAINT subiect_fk FOREIGN KEY (subiect_id) REFERENCES Subiect (id))");
				}
			
			addSubiectToStudentStmt = conn.prepareStatement("INSERT INTO Subiect_To_Student (student_id, subiect_id) VALUES (?, ?)");

			getStudentSubiectStmt = conn.prepareStatement("SELECT Subiect.subiect_nr, Subiect.name FROM Subiect, Subiect_To_Student " +
														  "WHERE student_id = ? and subiect_id = Subiect.id");

			deleteAllStudentSubiectStmt = conn.prepareStatement("DELETE FROM Subiect_To_Student");
			
			deleteAllSubiectFromStudentStmt = conn.prepareStatement("DELETE FROM Subiect_To_Student WHERE student_id = ?");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
	}

	public void addSubiectToStudent(List<Integer> students, List<Integer> subiects) 
	{
		try 
		{
			for (Integer studentID : students)
			{
				for (Integer subiectID : subiects)
				{
					addSubiectToStudentStmt.setInt(1, studentID);
					addSubiectToStudentStmt.setInt(2, subiectID);
					addSubiectToStudentStmt.executeUpdate();
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public List<Subiect> getStudentSubiect (List<Integer> students)
	{
		List<Subiect> subiects = new ArrayList<Subiect>();
		try 
		{
			for (Integer studentID : students)
			{
				getStudentSubiectStmt.setInt(1, studentID);
				ResultSet rs = getStudentSubiectStmt.executeQuery();
				while (rs.next()) 
				{

					subiects.add(new Subiect(rs.getInt("subiect_nr"),rs.getString("name")));
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return subiects;
	}
	
	public void deleteAllSubiectFromStudent (List<Integer> students) 
	{
		try 
		{
			for (Integer studentID : students)
			{
				deleteAllSubiectFromStudentStmt.setInt(1, studentID);
				deleteAllSubiectFromStudentStmt.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}

	public void deleteAllStudentSubiect() {
		try {
			deleteAllStudentSubiectStmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
