package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.MyCampusService;
import uk.ac.gla.dcs.team_n.users.AdminInterface;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.LecturerInterface;
import uk.ac.gla.dcs.team_n.users.StudentInterface;
import uk.ac.gla.dcs.team_n.users.TutorInterface;
import uk.ac.gla.dcs.team_n.users.User;

public class AuthenticationTest {
	
	/**
	 * The system shall authenticate users via the MyCampus single sign-on service.
	 */

	private AdminInterface admin;
	private MyCampusService myCampusService;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		admin = new User(true, false, false, false, data);
		myCampusService = myCampusService.getSingleton();
	}

	@Test
	public void test() {
		assertTrue(admin.authenticate(myCampusService, "admin", "admin"));
	}
}


