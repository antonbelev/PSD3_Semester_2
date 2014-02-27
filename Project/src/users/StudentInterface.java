package users;

public interface StudentInterface extends AuthenticateInterface {
	
	public void bookCourseSessionSlots(String studentID, String sessionName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentID, String courseName)
		throws IllegalOperationException;
	
	public void importUser(String string, String string2)
			throws IllegalOperationException;

}
