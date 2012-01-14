package EventsProjectMPR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ProjectMPR.Subiect;

public class Deanery {
	
	private Subiect subiect;

	private List processesSubiect = new ArrayList();

	public Subiect getSubiect() {
		return subiect;
	}

	public void setSubiect(Subiect subiect) {
		this.subiect = subiect;
	}

	public synchronized void addProcessSubiect(SubiectProcesses p) {
		processesSubiect.add(p);
	}

	public synchronized void removeProcessSubiect(SubiectProcesses p) {
		processesSubiect.remove(p);
	}

	public synchronized void processSubiect() {
		SubiectEvent subiectEvent = new SubiectEvent(this, subiect);
        Iterator list = processesSubiect.iterator();
        while( list.hasNext() ) {
            ( (SubiectProcesses) list.next() ).processSubiect(subiectEvent);
        }
	}
	

}
