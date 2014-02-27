package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import enums.SessionEnum;
import users.IllegalOperationException;
import attributes.Course;
import attributes.Data;
import attributes.Session;
import attributes.Student;

public class SessionTypesTest {

	/**
	 * The system shall support at least 10 different session types per course.
	 */
	
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		data = Data.getSingleton();
	}
	
	@Test
	public void sessionTypesTest() throws IllegalOperationException {
		//Create one course and add 10 different sessions for that course.
		
		Course c1 = new Course("PSD3", new HashMap<String, Student>(), new HashMap<String, Session>());
		data.getCourses().put(c1.getCourseName(), c1);
		
		for(int i = 0; i < 11; i++){
			Session s = new Session("Lab" + i, new Date(2013, 2, 24), new Date(2013, 3, 31), null, null, true, SessionEnum.WEEKLY, "lab");
            data.getSessions().put(s.getSessionName(), s);
			c1.getSessions().put(s.getSessionName(), s);
		}	
		
		assertTrue(data.getCourse(c1.getCourseName()).getSessions().size() >= 10);
		assertTrue(data.getSessions().size() >= 10); 
		
	}

}
