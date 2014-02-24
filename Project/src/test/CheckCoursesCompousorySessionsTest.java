package test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import enums.SessionEnum;
import users.IllegalOperationException;
import users.StudentInterface;
import users.User;
import attributes.Course;
import attributes.Data;
import attributes.Room;
import attributes.Session;
import attributes.Student;

public class CheckCoursesCompousorySessionsTest {
	
	/**
	 * As a student,
	 * I want to check that I have signed up for all compulsory sessions,
	 * So that I don't fail the course.
	 */
	
	private StudentInterface student;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		student = new User(false, true, false, false, data);
	}
	
	@Test
	public void checkCoursesCompousorySessions() {
		try {
			Course c1 = new Course("PSD3", new HashMap<String, Student>(), new HashMap<String, Session>());
			Room r1 = new Room("bo720");
			HashMap<String, Course> studentCourses = new HashMap<String, Course>();		
			studentCourses.put("PSD3", c1);
			Student s1 = new Student("666", "Psd Psd", studentCourses);
			HashMap<String, Student> sessionStudents = new HashMap<String, Student>();	
			sessionStudents.put(s1.getId(), s1);
			
			@SuppressWarnings("deprecation")
			Session sess1 = new Session("Lab1", new Date(2013, 2, 24), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.WEEKLY);
			Session sess2 = new Session("Lab2", new Date(2013, 1, 11), new Date(2013, 3, 31), sessionStudents, r1, true, SessionEnum.FORTNIGHTLY);
			
			c1.getSessions().put(sess1.getSessionName(), sess1);
			c1.getSessions().put(sess2.getSessionName(), sess2);
			c1.getStudentsEnrolled().put(s1.getName(), s1);
			
			data.getStudents().put(s1.getId(), s1);
			data.getSessions().put(sess1.getSessionName(), sess1);
			data.getSessions().put(sess2.getSessionName(), sess2);
			
			data.getCourses().put(c1.getCourseName(), c1);
			
			String expectedResult = "Compousory sessions: \n" + sess1.toString() + "\n" + sess2.toString() + "\n";
			String output = student.checkCoursesCompousorySessions("666", c1.getCourseName());		
			
			assertTrue(output.equals(expectedResult));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
