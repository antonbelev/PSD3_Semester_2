package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.attributes.Session;
import dcs.gla.ac.uk.team.n.enums.SessionEnum;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.LecturerInterface;
import dcs.gla.ac.uk.team.n.users.User;

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
