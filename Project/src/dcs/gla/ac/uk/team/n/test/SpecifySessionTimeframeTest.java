package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.enums.SessionEnum;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.LecturerInterface;
import dcs.gla.ac.uk.team.n.users.User;

public class SpecifySessionTimeframeTest {
	
	/**
	 *  As a lecturer,
	 *	I want to specify that a session is a one off, or recurs weekly or fortnightly,
     *  So that I don't have to create a large
	 *	number of sessions.
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
	public void specifySessionTimeframe() {
		try {
			//import some data from My Campus in order to have Lab1 already imported
			lecturer.importCourseFromMyCampus(myCampusService);
			String sessionName = "Lab1";
			
			lecturer.specifySessionTimeframe(sessionName, SessionEnum.FORTNIGHTLY);		

			assertTrue(data.getSession(sessionName).getTimeframe() == SessionEnum.FORTNIGHTLY);
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}


}
