package users;

import java.util.Date;

import attributes.Data;
import attributes.MyCampusService;
import enums.SessionEnum;

public class User implements AdminInterface, LecturerInterface,
		StudentInterface, TutorInterface {

	private boolean isAdmin;
	private boolean isStudent;
	private boolean isLecturer;
	private boolean isTutor;
	private Data data;

	public User(boolean isAdmin, boolean isStudent, boolean isLecturer,
			boolean isTutor, Data data) {
		this.isAdmin = isAdmin;
		this.isStudent = isStudent;
		this.isLecturer = isLecturer;
		this.data = data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}
	
	@Override /*new*/
	public void importUser(String username, String password) throws IllegalOperationException {
		if(!isLecturer && !isStudent && !isTutor && !isAdmin){
			throw new IllegalOperationException(
					"Permission denined. The current user does not exist in the system.");
		}
	}
	

	@Override
	public void importCourseFromMyCampus(MyCampusService myCampusService)
			throws IllegalOperationException {

		if (!isLecturer)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			data.importCourseFromMyCampus(myCampusService);
		}
	}

	@Override
	public void bookCourseSessionSlots(String studentID, String sessionName)
			throws IllegalOperationException {

		if (!isStudent)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			data.assignStudenttoSession(studentID, sessionName);
		}
	}

	@Override
	public String checkCoursesCompousorySessions(String studentID,
			String courseName) throws IllegalOperationException {

		if (!isStudent)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {

			return data.checkCoursesCompousorySessions(studentID, courseName);
		}
	}

	@Override
	public void addSessionToCourse(String sessionName, String coursename)
			throws IllegalOperationException {
		if (!isLecturer)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			data.assignSessionToCourse(sessionName, coursename);
		}
	}

	@Override
	public void specifySessionTimeframe(String sessionName,
			SessionEnum timeframe) throws IllegalOperationException {
		
		data.specifySessionTimeframe(sessionName, timeframe);
	}

	@Override
	public String seeSessionSlotsInformation(String sessionName)
			throws IllegalOperationException {
		if (!isLecturer)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			
			return data.getSession(sessionName).sessionInformation();
		}
	}

	@Override
	public void assignRoomToSlot(String roomName, String sessionName)
			throws IllegalOperationException {
		if (!isAdmin)
			throw new IllegalOperationException(
					"Permission) denined. The current user does not have the permissions to execute this operation");
		else {

			data.assignRoomToSlot(roomName, sessionName);
		}
	}

	@Override
	public void createSlotForSession(Date start, Date end, String sessionName)
			throws IllegalOperationException {
		if (!isAdmin)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			data.createSlotForSession(start, end, sessionName);
			
		}
	}

	@Override
	public boolean authenticate(MyCampusService myCampusService,
			String username, String password) {
		
		return data.authenticate(myCampusService, username, password);		
	}

}
