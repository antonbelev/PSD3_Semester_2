package test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import users.IllegalOperationException;
import users.StudentInterface;
import users.User;
import attributes.Data;
import attributes.Session;
import attributes.Student;

public class BookCourseSessionSlotsTest {
	
	/**
	*	As a student,
	*	I want to book a timetable slot for each session of my course,
	*	So that I can take the course.
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
	public void bookCourseSessionSlots() {
		try {
			String sessionName = "Lab2";
			//Put dummy session and try to assign student to it
			Session s = new Session(sessionName, null, null, new HashMap<String, Student>(), null, false, null, "lab");
			Student stud = new Student("1", "Anton Belev", null);
			//add the student to the existing students
			data.getStudents().put(stud.getId(), stud);
			data.getSessions().put(s.getSessionName(), s);			
			
			student.bookCourseSessionSlots("1", "Lab2");			
			
			assertTrue(data.getSession(sessionName).getStudents().containsKey("1"));
			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}
	
	

}
