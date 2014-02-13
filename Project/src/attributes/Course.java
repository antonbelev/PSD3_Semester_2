package attributes;

import java.util.HashSet;

public class Course {
	
	private String courseName;
	private HashSet<Student> studentsEnrolled = new HashSet<Student>();
	private HashSet<Session> sessions = new HashSet<Session>();
	private boolean isCompulsory;

	public Course(String courseName, HashSet<Student> studentsEnrolled,
			HashSet<Session> sessions, boolean isCompulsory) {
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

	public HashSet<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(HashSet<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public HashSet<Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashSet<Session> sessions) {
		this.sessions = sessions;
	}

	public boolean isCompulsory() {
		return isCompulsory;
	}

	public void setCompulsory(boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
	}
}
