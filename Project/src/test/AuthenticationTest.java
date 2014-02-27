package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import users.AdminInterface;
import users.IllegalOperationException;
import users.LecturerInterface;
import users.StudentInterface;
import users.TutorInterface;
import users.User;
import attributes.Data;
import attributes.MyCampusService;

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


