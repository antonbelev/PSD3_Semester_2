package users;

public interface StudentInterface {
	
	public void bookCourseSessionSlots(String studentID, String sessionName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentID, String courseName)
		throws IllegalOperationException;

}
