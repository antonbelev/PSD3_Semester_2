package dcs.gla.ac.uk.team.n.test;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import dcs.gla.ac.uk.team.n.attributes.Course;
import dcs.gla.ac.uk.team.n.attributes.Data;
import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.attributes.Session;
import dcs.gla.ac.uk.team.n.attributes.Student;
import dcs.gla.ac.uk.team.n.users.IllegalOperationException;
import dcs.gla.ac.uk.team.n.users.LecturerInterface;
import dcs.gla.ac.uk.team.n.users.User;

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
