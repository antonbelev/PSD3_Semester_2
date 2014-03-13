package dcs.gla.ac.uk.team.n.attributes;

import java.util.HashMap;

public class Course {
	
	private String courseName;
	private HashMap<String, Student> studentsEnrolled = new HashMap<String, Student>();
	private HashMap<String, Session> sessions = new HashMap<String, Session>();
	

	public Course(String courseName, HashMap<String, Student> studentsEnrolled,
			HashMap<String, Session> sessions) {
		super();
		this.courseName = courseName;
		this.studentsEnrolled = studentsEnrolled;
		this.sessions = sessions;
	}
	
	@Override
	public String toString(){
		String s = "Course name " + courseName;		
		for (Session session: sessions.values())
			s += session.toString() + " \n";		
		return s;		
	}
	

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public HashMap<String, Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(HashMap<String, Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public HashMap<String, Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashMap<String, Session> sessions) {
		this.sessions = sessions;
	}
	
	
}
