package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.Session;
import dcs.gla.ac.uk.team.n.users.AdminInterface;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.User;

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
	
	@SuppressWarnings("deprecation")
	@Test
	public void createSlotForSession() {
		try {
			String sessionName = "Lab1";
	
			Session s = new Session(sessionName, null, null, null, null, false, null, "lab");
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