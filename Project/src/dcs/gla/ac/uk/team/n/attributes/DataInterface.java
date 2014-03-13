package dcs.gla.ac.uk.team.n.attributes;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import dcs.gla.ac.uk.team.n.enums.SessionEnum;

public interface DataInterface {

	public Student getStudent(String studentId);
	
	public Course getCourse(String courseName);
	
	public Session getSession(String sessionName);
	
	public void assignSessionToCourse(String sessionName, String courseName);
	
	public void assignStudentToCourse(String studentId, String courseName);
	
	public void assignStudenttoSession(String studentId, String sessionName);
	
	public Set<Student> getStudentsForCourse(String courseName);
	
	public HashMap<String, Course> getCoursesForStudent(String studentId);
	
	public Set<Session> getSessionsForCourse(String courseName);
	
	public Set<Student> getStudentsForSession(String sessionName, String courseName);
	
	public void importCourseFromMyCampus(MyCampusService myCampusService);
	
	public String checkCoursesCompousorySessions(String studentID, String courseName);
	
	public void createSlotForSession(Date start, Date end, String sessionName);
	
	public void assignRoomToSlot(String roomName, String sessionName);
	
	public void specifySessionTimeframe(String sessionName,
			SessionEnum timeframe);
}
