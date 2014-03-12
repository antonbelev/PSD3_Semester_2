package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import enums.SessionEnum;

import users.AdminInterface;
import users.IllegalOperationException;
import users.User;
import attributes.Course;
import attributes.Data;
import attributes.Room;
import attributes.Session;
import attributes.Student;

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
		data.getCourses().put(c1.getCourseName(), c2);
		
		String output = admin.checkForCourseClashes();
		System.out.println(output);
		assertTrue(output.contains("Lab1") && output.contains("Lab2"));
		
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}		
	}

}
