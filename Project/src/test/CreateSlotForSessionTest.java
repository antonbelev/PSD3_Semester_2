package test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import users.AdminInterface;
import users.IllegalOperationException;
import users.User;
import attributes.Data;
import attributes.Session;

public class CreateSlotForSessionTest {
	
	/**
	 *  As a administrator
	 *	I want to create a timetable slot for a session
	 *	So that rooms can be assigned to slots.
	 */
	
	
	private AdminInterface admin;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		admin = new User(true, false, false, false, data);
	}
	
	@Test
	public void createSlotForSession() {
		try {
			String sessionName = "Lab1";
	
			Session s = new Session(sessionName, null, null, null, null, false, null);
			data.getSessions().put(s.getSessionName(), s);
			Date start = new Date(2013, 2, 24);
			Date end = new Date(2013, 3, 31);
			
			admin.createSlotForSession(start, end, sessionName);
			
			assertTrue(data.getSession(sessionName).getStart().equals(start) &&
					data.getSession(sessionName).getEnd().equals(end));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}