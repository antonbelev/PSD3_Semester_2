package users;

import attributes.MyCampusService;

public class User implements AdminInterface, LecturerInterface, StudentInterface, TutorInterface{

	private boolean isAdmin;
	private boolean isStudent;
	private boolean isLecturer;
	private boolean isTutor;
	
	public User(boolean isAdmin, boolean isStudent, boolean isLecturer,
			boolean isTutor) {
		this.isAdmin = isAdmin;
		this.isStudent = isStudent;
		this.isLecturer = isLecturer;
		this.isTutor = isTutor;
	}

	@Override
	public boolean importCourseFromMyCampus(MyCampusService myCampusService)
			throws IllegalOperationException {
		
		if (!isLecturer)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return true;
		}
	}

	
	
	
}
