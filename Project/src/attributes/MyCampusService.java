package attributes;

import java.util.Date;
import java.util.HashMap;

import enums.SessionEnum;

public class MyCampusService {
	
	private static HashMap<String, Course> courses;
	
	private static MyCampusService myCampuseInstance;

	public MyCampusService() {
		courses = new HashMap<String, Course>();
	}

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}
	
	public static MyCampusService getSingleton() {
		if (myCampuseInstance == null) {
			myCampuseInstance = new MyCampusService();
			importMyCampusData();
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
		sessionStudents.put(s1.getName(), s1);
		
		@SuppressWarnings("deprecation")
		Session sess1 = new Session("Lab1", new Date(2013, 2, 24), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.WEEKLY);
		
		c1.getSessions().put(sess1.getSessionName(), sess1);
		c1.getStudentsEnrolled().put(s1.getName(), s1);
		
		courses.put(c1.getCourseName(), c1);		
	}

	@Override
	public String toString() {
		return "MyCampusService [courses=" + courses + "]";
	}
	
	
}
