package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.User;

public class NumberOfUsersTest {
	
	/**
	 * The system shall support at least 1000 different users.
	 */
	
	private Data data;
	private ArrayList<User> users;
	
	@Before
	public void setUp() throws Exception {
		data = Data.getSingleton();
		users = new ArrayList<User>();
	}
	
	@Test
	public void numberOfUsersTest() throws IllegalOperationException {
		//Create 1000 students
		
		for(int i = 0; i < 1001; i++){
			users.add(new User(false,true,false,false,data));
		}	
		
		assertTrue(users.size() >= 1000);		
	}
}
