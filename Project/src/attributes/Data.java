package attributes;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Data implements DataInterface{
	
	private HashMap<String, Course> courses; 
	private HashMap<String, Student> students;
	private HashMap<String, Session> sessions;
	
	private static Data dataInstance;
	
	public Data() {
		this.courses = new HashMap<String, Course>();
		this.students = new HashMap<String, Student>();
		this.sessions = new HashMap<String, Session>();
	}
	
	public static Data getSingleton() {
		if (dataInstance == null) {
			dataInstance = new Data();
		}
		return dataInstance;
	}

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}

	public HashMap<String, Student> getStudents() {
		return students;
	}

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

	public HashMap<String, Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashMap<String, Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public Student getStudent(String studentId) {
		return students.get(studentId);
	}

	@Override
	public Course getCourse(String courseName) {
		return courses.get(courseName);
	}

	@Override
	public Session getSession(String sessionName) {
		return sessions.get(sessionName);
	}

	@Override
	public void assignSessionToCourse(String sessionName, String courseName) {
		Session s = getSession(sessionName);
		Course c = getCourse(courseName);
		c.getSessions().put(s.getSessionName(), s);
	}

	@Override
	public void assignStudentToCourse(String studentId, String courseName) {
		Student s = getStudent(studentId);
		Course c = getCourse(courseName);
		c.getStudentsEnrolled().put(studentId, s);
	}

	@Override
	public void assignStudenttoSession(String studentId, String sessionName) {
		Student s = getStudent(studentId);
		Session session = getSession(sessionName);
		session.getStudents().put(studentId, s);	
	}

	@Override
	public Set<Student> getStudentsForCourse(String courseName) {
		Course c = getCourse(courseName);
		return (Set<Student>) c.getStudentsEnrolled().values();
	}

	@Override
	public Set<Session> getSessionsForCourse(String courseName) {
		Course c = getCourse(courseName);
		return (Set<Session>) c.getSessions().values();
	}

	@Override
	public Set<Student> getStudentsForSession(String sessionName,
			String courseName) {
		Session s = getSession(sessionName);
		return (Set<Student>) s.getStudents().values();
	}

	@Override
	public void importCourseFromMyCampus(MyCampusService myCampusService) {
		HashMap<String, Course> myCampusCourses =  myCampusService.getCourses();		
		
		for (Entry<String, Course> entry: myCampusCourses.entrySet()){
			courses.put(entry.getKey(), entry.getValue());
		}		
	}

	@Override
	public Set<Course> getCoursesForStudent(String studentId) {
		return (Set<Course>) getStudent(studentId).getCourses();
	}


	
}
