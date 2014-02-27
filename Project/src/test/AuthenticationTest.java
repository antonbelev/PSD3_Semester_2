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
	
	private LecturerInterface lecturer;
	private StudentInterface student;
	private TutorInterface tutor;
	private AdminInterface admin;
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
	public void test() {
		try {
			//import some data from My Campus in order to have PSD3 already imported
			lecturer.importUser("SilviyaSoti", "NameOfTheCat");		
			
			
			assertTrue(myCampusService.getUsers().containsKey("SilviyaSoti"));
			
		
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}
}


