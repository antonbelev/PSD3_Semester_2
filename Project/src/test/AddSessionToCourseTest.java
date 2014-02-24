package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import users.IllegalOperationException;
import users.LecturerInterface;
import users.User;
import attributes.Data;
import attributes.MyCampusService;
import attributes.Session;
import enums.SessionEnum;

public class AddSessionToCourseTest {
	
	/**
	 * As a lecturer,
	 * I want to add a session to a course,
     * So that timetable slots can be identified
	 */
	
	private LecturerInterface lecturer;
	private MyCampusService myCampusService;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		lecturer = new User(false, false, true, false, data);
		myCampusService = myCampusService.getSingleton();
	}
	
	@Test
	public void importCourseFromMyCampusTest() {
		try {
			//import some data from My Campus in order to have PSD3 already imported
			lecturer.importCourseFromMyCampus(myCampusService);
			Session s = new Session("Lab2", null, null, null, null, true, SessionEnum.WEEKLY);
			data.getSessions().put(s.getSessionName(), s);
			
			lecturer.addSessionToCourse("Lab2", "PSD3");			

			assertTrue(data.getSessions().containsKey("Lab2"));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
