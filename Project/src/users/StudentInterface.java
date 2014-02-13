package users;

public interface StudentInterface {
	
	public boolean bookCourseSessionSlots(String studentName, String courseName)
		throws IllegalOperationException;
	
	public String checkCoursesCompousorySessions(String studentName, String courseName)
		throws IllegalOperationException;

}
