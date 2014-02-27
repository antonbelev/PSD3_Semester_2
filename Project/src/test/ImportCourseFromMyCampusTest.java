package test;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import users.IllegalOperationException;
import users.LecturerInterface;
import users.User;
import attributes.Course;
import attributes.Data;
import attributes.MyCampusService;
import attributes.Session;
import attributes.Student;

public class ImportCourseFromMyCampusTest {
	
	/**
	 * As a lecturer,
	 * I want to import a MyCampus course,
	 * So that teaching sessions can be identified
	 */
	
	private LecturerInterface lecturer;
	private MyCampusService myCampusService;
	private Data data;
	
	@Before
	public void setUp() throws Exception {
		//Given a
		data = Data.getSingleton();
		lecturer = new User(false, false, true, false, data);
		myCampusService = MyCampusService.getSingleton();
	}
	
	@Test
	public void importCourseFromMyCampusTest() {
		try {
			
			lecturer.importCourseFromMyCampus(myCampusService);
			
			for (Entry<String, Course> course : myCampusService.getCourses().entrySet()){
				assertTrue(data.getCourses().containsKey(course.getKey()));
				
				for (Entry<String, Student> student : course.getValue().getStudentsEnrolled().entrySet()){
					assertTrue(data.getStudents().containsKey(student.getKey()));
				}
				
				for (Entry<String, Session> session : course.getValue().getSessions().entrySet()){
					assertTrue(data.getSessions().containsKey(session.getKey()));
				}
			}			
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}	
	}

}
