package attributes;

import java.util.HashMap;

public class Course {
	
	private String courseName;
	private HashMap<String, Student> studentsEnrolled = new HashMap<String, Student>();
	private HashMap<String, Session> sessions = new HashMap<String, Session>();
	private boolean isCompulsory;

	public Course(String courseName, HashMap<String, Student> studentsEnrolled,
			HashMap<String, Session> sessions, boolean isCompulsory) {
		super();
		this.courseName = courseName;
		this.studentsEnrolled = studentsEnrolled;
		this.sessions = sessions;
		this.isCompulsory = isCompulsory;
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

	public boolean isCompulsory() {
		return isCompulsory;
	}

	public void setCompulsory(boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
	}
}
