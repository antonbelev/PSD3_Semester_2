package attributes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import enums.SessionEnum;

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
		
		for (Entry<String, Course> course: myCampusCourses.entrySet()){
			courses.put(course.getKey(), course.getValue());
			
			for (Entry<String, Student> student : course.getValue().getStudentsEnrolled().entrySet()){
				students.put(student.getKey(), student.getValue());
			}
			
			for (Entry<String, Session> session : course.getValue().getSessions().entrySet()){
				sessions.put(session.getKey(), session.getValue());
			}
		}		
	}

	@Override
	public Set<Course> getCoursesForStudent(String studentId) {
		return (Set<Course>) getStudent(studentId).getCourses();
	}

	@Override
	public String checkCoursesCompousorySessions(String studentID,
			String courseName) {
		Set<Course> courseSet = getCoursesForStudent(studentID);
		Course course = null;
		for (Course c : courseSet){
			if (c.getCourseName().equals(courseName))
			{
				course = c;
				break;
			}
		}
		
		String sessionReport = "Compousory sessions: \n";
		
		for (Session s : course.getSessions().values()){
			if (s.isCompulsory())
				sessionReport += s.toString() + "\n";
		}
		
		return sessionReport;
	}

	@Override
	public void createSlotForSession(Date start, Date end,
			String sessionName) {
		Session s = getSession(sessionName);
		s.setStart(start);
		s.setEnd(end);		
	}

	@Override
	public void assignRoomToSlot(String roomName, String sessionName) {
		Session s = getSession(sessionName);
		s.setRoom(new Room(roomName));		
	}

	@Override
	public void specifySessionTimeframe(String sessionName,
			SessionEnum timeframe) {
		Session s = getSession(sessionName);
		s.setTimeframe(timeframe);
	}


	
}
