package uk.ac.gla.dcs.team_n.users;

public interface StudentInterface extends AuthenticateInterface {
	
	public void bookCourseSessionSlots(String studentID, String sessionName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentID, String courseName)
		throws IllegalOperationException;
}
