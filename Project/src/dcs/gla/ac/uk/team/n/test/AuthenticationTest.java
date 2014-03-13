package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.users.AdminInterface;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.LecturerInterface;
import dcs.gla.ac.uk.team.n.users.StudentInterface;
import dcs.gla.ac.uk.team.n.users.TutorInterface;
import dcs.gla.ac.uk.team.n.users.User;

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


