package users;

import java.util.Date;

import enums.SessionEnum;
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

	@Override
	public boolean bookCourseSessionSlots(String studentName, String courseName)
			throws IllegalOperationException {

		if (!isStudent)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return true;
		}
	}

	@Override
	public String checkCoursesCompousorySessions(String studentName, String courseName)
			throws IllegalOperationException {
		
		if (!isStudent)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return null;
		}
	}

	@Override
	public boolean addSessionToCourse(String sessionName, String coursename)
			throws IllegalOperationException {
		if (!isLecturer)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return true;
		}
	}

	@Override
	public boolean specifySessionTimeframe(String sessionName,
			SessionEnum timeframe) throws IllegalOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String seeSessionSlotsInformation(String sessionName)
			throws IllegalOperationException {
		if (!isLecturer)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return null;
		}
	}

	@Override
	public boolean assignRoomToSlot(String roomName, String sessionName)
			throws IllegalOperationException {
		if (!isAdmin)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return true;
		}
	}

	@Override
	public boolean createSlotForSession(Date start, Date end,
			String courseName, String sessionName)
			throws IllegalOperationException {
		if (!isAdmin)
			throw new IllegalOperationException("Permission denined. The current user does not have the permissions to execute this operation");
		else
		{
			
			return true;
		}
	}

	
	
	
}
