package attributes;

import java.util.HashSet;

public class Data {
	
	private HashSet<Course> courses = new HashSet<Course>();
	private HashSet<Student> students = new HashSet<Student>();
	private HashSet<Session> sessions = new HashSet<Session>();
		
	public Data(HashSet<Course> courses, HashSet<Student> students,
			HashSet<Session> sessions) {
		super();
		this.courses = courses;
		this.students = students;
		this.sessions = sessions;
	}
	
	public HashSet<Course> getCourses() {
		return courses;
	}
	public void setCourses(HashSet<Course> courses) {
		this.courses = courses;
	}
	public HashSet<Student> getStudents() {
		return students;
	}
	public void setStudents(HashSet<Student> students) {
		this.students = students;
	}
	public HashSet<Session> getSessions() {
		return sessions;
	}
	public void setSessions(HashSet<Session> sessions) {
		this.sessions = sessions;
	}
	
}
