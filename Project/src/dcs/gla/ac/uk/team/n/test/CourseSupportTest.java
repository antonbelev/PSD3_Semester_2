package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Course;
import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.Session;
import dcs.gla.ac.uk.team.n.attributes.Student;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;

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
