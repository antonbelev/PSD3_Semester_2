package users;

import java.util.Date;
import java.util.Set;

import attributes.Course;
import attributes.DataInterface;
import attributes.MyCampusService;
import attributes.Session;
import enums.SessionEnum;

public class User implements AdminInterface, LecturerInterface,
		StudentInterface, TutorInterface {

	private boolean isAdmin;
	private boolean isStudent;
	private boolean isLecturer;
	private boolean isTutor;
	private DataInterface data;

	public User(boolean isAdmin, boolean isStudent, boolean isLecturer,
			boolean isTutor) {
		this.isAdmin = isAdmin;
		this.isStudent = isStudent;
		this.isLecturer = isLecturer;
		this.isTutor = isTutor;
	}

	public void setData(DataInterface data) {
		this.data = data;
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
	public void createSlotForSession(Date start, Date end,
			String courseName, String sessionName)
			throws IllegalOperationException {
		if (!isAdmin)
			throw new IllegalOperationException(
					"Permission denined. The current user does not have the permissions to execute this operation");
		else {
			data.createSlotForSession(start, end, courseName, sessionName);
			
		}
	}

}
