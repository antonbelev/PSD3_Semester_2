package users;

public interface StudentInterface {
	
	public void bookCourseSessionSlots(String studentID, String courseName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentID, String courseName)
		throws IllegalOperationException;

}
