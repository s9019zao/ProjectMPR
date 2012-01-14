package EventsProjectMPR;

import java.util.EventObject;

import ProjectMPR.Subiect;

public class SubiectEvent extends EventObject {
	
	private Subiect subiect;

	public SubiectEvent(Object source, Subiect s) {
		super(source);
		subiect=s;
	}

	public Subiect getSubiect() {
		return subiect;
	}

	public void setSubiect(Subiect subiect) {
		this.subiect = subiect;
	}

}
