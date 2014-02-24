package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import users.AdminInterface;
import users.IllegalOperationException;
import users.User;
import attributes.Data;
import attributes.MyCampusService;
import attributes.Session;

public class AssignRoomToSlotTest {
	
	/**
	 * As a administrator,
     * I want to assign a room to a timetable slot,
     * So that room bookings can be recorded.
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
	public void assignRoomToSlot() {
		try {
			String sessionName = "Lab1";
			String roomName = "bo720";
			//Put dummy session and try to assign room to this session
			Session s = new Session(sessionName, null, null, null, null, false, null);
			data.getSessions().put(s.getSessionName(), s);
			
			admin.assignRoomToSlot(roomName, sessionName);
			
			assertTrue(data.getSession(sessionName).getRoom().getRoomName() == roomName);
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
