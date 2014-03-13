package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Course;
import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.Session;
import uk.ac.gla.dcs.team_n.attributes.Student;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;

public class CourseSupportTest {
	
	/**
	 *  The system shall support at least 100 courses.
	 */
	
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
	}
	
	@Test
	public void courseSessioTest() throws IllegalOperationException {
		//Create 100 courses and add them to the data.
		for (int i = 0; i < 100; i++){
			data.getCourses().put("PSD3" + i, new Course("PSD3" + i, new HashMap<String, Student>(), new HashMap<String, Session>()));
		}		
		assertTrue(data.getCourses().size() >= 100);	
	}

}
