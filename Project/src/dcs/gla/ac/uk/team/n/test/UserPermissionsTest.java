package dcs.gla.ac.uk.team.n.test;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.User;

public class UserPermissionsTest {
	
	/**
	 * The system shall distinguish between lecturers, administrators, tutors and student roles.
	 */
	
	private User admin;
	private User lecturer;
	private User student;
	private MyCampusService myCampusService;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		admin = new User(true, false, false, false, data);
		student = new User(false, true, false, false, data);
		lecturer = new User(false, false, true, false, data);
		myCampusService = MyCampusService.getSingleton();
	}
	
	@Test(expected=IllegalOperationException.class)
	public void testAdminPermissions() throws IllegalOperationException {
		//Illigal operation for admin
		admin.importCourseFromMyCampus(myCampusService);
	}
	
	@Test(expected=IllegalOperationException.class)
	public void testLecturerPermissions() throws IllegalOperationException {
		//Illigal operation for lecturer
		lecturer.checkCoursesCompousorySessions("1", "PSD3");
	}
	
	@Test(expected=IllegalOperationException.class)
	public void testStudentPermission() throws IllegalOperationException {
		//Illigal operation for student
		student.importCourseFromMyCampus(myCampusService);
	}

}
