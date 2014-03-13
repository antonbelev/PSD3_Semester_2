package dcs.gla.ac.uk.team.n.users;

public interface StudentInterface extends AuthenticateInterface {
	
	public void bookCourseSessionSlots(String studentID, String sessionName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentID, String courseName)
		throws IllegalOperationException;
}
