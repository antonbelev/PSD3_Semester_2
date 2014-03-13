package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.MyCampusService;
import uk.ac.gla.dcs.team_n.attributes.Session;
import uk.ac.gla.dcs.team_n.enums.SessionEnum;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.LecturerInterface;
import uk.ac.gla.dcs.team_n.users.User;

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
		myCampusService = MyCampusService.getSingleton();
	}
	
	@Test
	public void addSessionToCourse() {
		try {
			//import some data from My Campus in order to have PSD3 already imported
			lecturer.importCourseFromMyCampus(myCampusService);
			Session s = new Session("Lab2", null, null, null, null, true, SessionEnum.WEEKLY, "lab");
			data.getSessions().put(s.getSessionName(), s);
			
			lecturer.addSessionToCourse("Lab2", "PSD3");			

			assertTrue(data.getSessions().containsKey("Lab2"));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
