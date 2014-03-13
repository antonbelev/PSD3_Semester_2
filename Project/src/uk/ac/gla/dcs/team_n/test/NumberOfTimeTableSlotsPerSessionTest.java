package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.Session;
import uk.ac.gla.dcs.team_n.attributes.TimeTableSlot;
import uk.ac.gla.dcs.team_n.enums.SessionEnum;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;

public class NumberOfTimeTableSlotsPerSessionTest {
	
	/**
	 * The system shall support at least 20 different timetable slots per session.
	 */
	
private Data data;
	
	@Before
	public void setUp() throws Exception {
		data = Data.getSingleton();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void numberOfTimeTableSlotsPerSessionTest() throws IllegalOperationException {
		//Create one course and add 10 different sessions for that course.
		
		Session s = new Session("Lab1", new Date(2013, 2, 24), new Date(2013, 3, 31), null, null, true, SessionEnum.WEEKLY, "lab");
		data.getSessions().put(s.getSessionName(), s);
		
		for(int i = 0; i < 21; i++){            
			s.getTimeTableSlots().add(new TimeTableSlot(new Date(), new Date()));
		}	
		
		assertTrue(data.getSession(s.getSessionName()).getTimeTableSlots().size() >= 20);		
	}

}
