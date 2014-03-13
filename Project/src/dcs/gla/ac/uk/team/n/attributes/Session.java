package dcs.gla.ac.uk.team.n.attributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dcs.gla.ac.uk.team.n.enums.SessionEnum;

public class Session {
	
	private String sessionName;
	private Date start;
	private Date end;
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private Room room;	
	private boolean isCompulsory;
	private SessionEnum timeframe;
	private String type;
	private ArrayList<TimeTableSlot> timeTableSlots;
	
	
	public Session(String sessionName, Date start, Date end,
			HashMap<String, Student> students, Room room, boolean isCompulsory,
			SessionEnum timeframe, String type) {
		super();
		this.sessionName = sessionName;
		this.start = start;
		this.end = end;
		this.students = students;
		this.room = room;
		this.isCompulsory = isCompulsory;
		this.timeframe = timeframe;
		this.type = type;
		this.timeTableSlots = new ArrayList<TimeTableSlot>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<TimeTableSlot> getTimeTableSlots() {
		return timeTableSlots;
	}

	public void setTimeTableSlots(ArrayList<TimeTableSlot> timeTableSlots) {
		this.timeTableSlots = timeTableSlots;
	}

	public SessionEnum getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(SessionEnum timeframe) {
		this.timeframe = timeframe;
	}

	@Override
	public String toString(){
		return "Session name: " + sessionName + " type: " + type + " start: " + start +
				 " end: " + end + " room: " + room + " isCompulsory: " + isCompulsory;
		
	}	
	
	public synchronized String sessionInformation() {
		String students = "Students enrolled: \n";
		String information = toString();
		
		for (Student s : getStudents().values()){
			students += s + "\n";
		}
		
		return information + students;
	}
	
	public boolean isCompulsory() {
		return isCompulsory;
	}

	public void setCompulsory(boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
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
