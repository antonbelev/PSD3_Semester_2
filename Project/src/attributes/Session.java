package attributes;

import java.util.Date;
import java.util.HashMap;

public class Session {
	
	private String sessionName;
	private Date start;
	private Date end;
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private Room room;	
	
	public Session(String sessionName, Date start, Date end,
			HashMap<String, Student> students, Room room) {
		super();
		this.sessionName = sessionName;
		this.start = start;
		this.end = end;
		this.students = students;
		this.room = room;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public HashMap<String, Student> getStudents() {
		return students;
	}
	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

}
