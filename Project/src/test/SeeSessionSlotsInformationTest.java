package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import users.IllegalOperationException;
import users.LecturerInterface;
import users.User;
import attributes.Data;
import attributes.MyCampusService;

public class SeeSessionSlotsInformationTest {
		
	/**
	 * As a lecturer,
	 * I want to see the details (time, location, students, tutor) or every timetable slot in a session,
	 * So that I know when sessions happen.
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
	public void seeSessionSlotsInformation() {
		try {
			//import some data from My Campus in order to have Lab1 already imported
			lecturer.importCourseFromMyCampus(myCampusService);
			String sessionName = "Lab1";
			
			String expectedResult = data.getSession(sessionName).sessionInformation();
			String result = lecturer.seeSessionSlotsInformation(sessionName);

			assertTrue(expectedResult.equals(result));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}
	

}
