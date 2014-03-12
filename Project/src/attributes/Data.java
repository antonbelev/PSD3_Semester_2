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
		if (!sessions.containsKey(sessionName))
			sessions.put(sessionName, new Session(sessionName, new Date(2013, 2, 24), new Date(2013, 3, 31), new HashMap<String, Student>(), new Room("bo720"), true, SessionEnum.WEEKLY, "lab"));
			
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
	public HashMap<String, Course> getCoursesForStudent(String studentId) {
		return getStudent(studentId).getCourses();
	}

	@Override
	public String checkCoursesCompousorySessions(String studentID,
			String courseName) {
		HashMap<String, Course> courseSet = getCoursesForStudent(studentID);
		Course course = null;
		for (Entry<String, Course> c : courseSet.entrySet()){
			if (c.getValue().getCourseName().equals(courseName))
			{
				course = c.getValue();
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

	public boolean authenticate(MyCampusService myCampusService,
			String username, String password) {		
		if (!myCampusService.getUsers().containsKey(username))
			return false;		
		return myCampusService.getUsers().get(username).equals(password);
	}

	public String checkForCourseClashes() {
		
		HashMap<String, Course> clashingCourses = new HashMap<String, Course>();
		
		HashMap<String, Course> courseSet = getCourses();
		
		String clash = "The following courses overlap: \n";
		String noClash = "There are no overlapping courses.\n";
		
		for (Entry<String, Course> course1 : courseSet.entrySet()){
			for (Entry<String, Course> course2 : courseSet.entrySet()){
				if (!course1.getKey().equals(course2.getKey())){
					for (Entry<String, Session> s1 : course1.getValue().getSessions().entrySet()){
						for (Entry<String, Session> s2 : course2.getValue().getSessions().entrySet()){
							Session ses1 = s1.getValue();
							Session ses2 = s2.getValue();
							if (!s1.getKey().equals(s2.getKey())){
								if (ses1.getStart().compareTo(ses2.getEnd()) <= 0
										&& ses2.getStart().compareTo(ses1.getEnd()) <= 0){
									clashingCourses.put(course1.getKey(), course1.getValue());
									clashingCourses.put(course2.getKey(), course2.getValue());
								}
							}
						}
					}					
				}
			}
		}
		
		if (clashingCourses.size() == 0)
			return noClash;
		
		for (Entry<String, Course> course : clashingCourses.entrySet()){
			clash += course.getKey() + "\n";
		}	
		return clash;
	}	
}
