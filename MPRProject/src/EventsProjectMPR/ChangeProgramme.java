package EventsProjectMPR;

public class ChangeProgramme implements SubiectProcesses{
	
	public void processSubiect(SubiectEvent subiect) {
		System.out.println("Changing the programme of "+ subiect.getSubiect());

	}

}

