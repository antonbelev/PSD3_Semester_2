package uk.ac.gla.dcs.team_n.attributes;

import java.util.Date;
import java.util.HashMap;

import uk.ac.gla.dcs.team_n.enums.SessionEnum;

public class MyCampusService {
	
	private static HashMap<String, Course> courses;
	private static HashMap<String, String> users;
	
	private static MyCampusService myCampuseInstance;

	public MyCampusService() {
		courses = new HashMap<String, Course>();
		users = new HashMap<String, String>();
	}

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		MyCampusService.courses = courses;
	}
	
	public static MyCampusService getSingleton() {
		if (myCampuseInstance == null) {
			myCampuseInstance = new MyCampusService();
			importMyCampusData();
			importUsers();
		}
		return myCampuseInstance;
	}

	private static void importMyCampusData() {
		Course c1 = new Course("PSD3", new HashMap<String, Student>(), new HashMap<String, Session>());
		Room r1 = new Room("bo720");
		HashMap<String, Course> studentCourses = new HashMap<String, Course>();		
		studentCourses.put("PSD3", c1);
		Student s1 = new Student("1", "Pancho Durvodelski", studentCourses);
		HashMap<String, Student> sessionStudents = new HashMap<String, Student>();	
		sessionStudents.put(s1.getId(), s1);
		
		@SuppressWarnings("deprecation")
		Session sess1 = new Session("Lab1", new Date(2013, 2, 24), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.WEEKLY, "lab");
		
		c1.getSessions().put(sess1.getSessionName(), sess1);
		c1.getStudentsEnrolled().put(s1.getName(), s1);
		
		courses.put(c1.getCourseName(), c1);		
	}
	
	public static HashMap<String, String> getUsers() {
		return users;
	}

	public static void setUsers(HashMap<String, String> users) {
		MyCampusService.users = users;
	}

	private static void importUsers() {
		String userName1 = "por";
		String password1 = "po123";
		
		String userName2 = "admin";
		String password2 = "admin";
		users.put(userName1, password1);
		users.put(userName2, password2);
	}

	@Override
	public String toString() {
		return "MyCampusService [courses=" + courses + "]";
	}
	
}
