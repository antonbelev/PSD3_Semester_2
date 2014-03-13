package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Course;
import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.Room;
import dcs.gla.ac.uk.team.n.attributes.Session;
import dcs.gla.ac.uk.team.n.attributes.Student;
import dcs.gla.ac.uk.team.n.enums.SessionEnum;
import dcs.gla.ac.uk.team.n.users.AdminInterface;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.User;

public class CheckForNoTimeslotClashes {

	/**
	 *  As a administrator
	 *	I want to check that there are no timetable slot clashes between courses
	 *	So that students are able to complete the course.
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
	public void test() {
		
		try {
		Course c1 = new Course("PSD3", new HashMap<String, Student>(), new HashMap<String, Session>());
		Course c2 = new Course("DB3", new HashMap<String, Student>(), new HashMap<String, Session>());
		
		Room r1 = new Room("bo720");
		HashMap<String, Student> sessionStudents = new HashMap<String, Student>();	
		
		@SuppressWarnings("deprecation")
		Session sess1 = new Session("Lab1", new Date(2013, 2, 24), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.WEEKLY, "lab");
		Session sess2 = new Session("Lab2", new Date(2013, 2, 11), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.FORTNIGHTLY, "lab");
		
		c1.getSessions().put(sess1.getSessionName(), sess1);
		c2.getSessions().put(sess2.getSessionName(), sess2);
		
		data.getSessions().put(sess1.getSessionName(), sess1);
		data.getSessions().put(sess2.getSessionName(), sess2);
		
		data.getCourses().put(c1.getCourseName(), c1);
		data.getCourses().put(c2.getCourseName(), c2);
		
		String output = admin.checkForCourseClashes();
		System.out.println(output);
		assertTrue(output.contains("PSD3") && output.contains("DB3"));
		
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}		
	}

}
