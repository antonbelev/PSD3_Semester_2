package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.MyCampusService;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.LecturerInterface;
import uk.ac.gla.dcs.team_n.users.User;

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
		myCampusService = MyCampusService.getSingleton();
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
