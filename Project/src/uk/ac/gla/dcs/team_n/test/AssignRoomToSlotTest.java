package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.Session;
import uk.ac.gla.dcs.team_n.users.AdminInterface;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.User;

public class AssignRoomToSlotTest {
	
	/**
	 * As a administrator,
     * I want to assign a room to a timetable slot,
     * So that room bookings can be recorded.
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
	public void assignRoomToSlot() {
		try {
			String sessionName = "Lab1";
			String roomName = "bo720";
			//Put dummy session and try to assign room to this session
			Session s = new Session(sessionName, null, null, null, null, false, null, "lab");
			data.getSessions().put(s.getSessionName(), s);
			
			admin.assignRoomToSlot(roomName, sessionName);
			
			assertTrue(data.getSession(sessionName).getRoom().getRoomName() == roomName);
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
