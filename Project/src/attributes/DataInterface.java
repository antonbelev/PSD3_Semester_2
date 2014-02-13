package attributes;

import java.util.Set;

public interface DataInterface {

	public Student getStudent(String studentId);
	
	public Course getCourse(String courseName);
	
	public Session getSession(String sessionName);
	
	public void assignSessionToCourse(String sessionName, String courseName);
	
	public void assignStudentToCourse(String studentId, String courseName);
	
	public void assignStudenttoSession(String studentId, String sessionName, String courseName);
	
	public Set<Student> getStudentsForCourse(String courseName);
	
	public Set<Session> getSessionsForCourse(String courseName);
	
	public Set<Student> getStudentsForSession(String sessionName, String courseName);
	
	public void importCourseFromMyCampus(MyCampusService myCampusService);
}
