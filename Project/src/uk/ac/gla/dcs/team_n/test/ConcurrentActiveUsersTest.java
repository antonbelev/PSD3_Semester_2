package uk.ac.gla.dcs.team_n.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.ac.gla.dcs.team_n.attributes.Data;
import uk.ac.gla.dcs.team_n.attributes.MyCampusService;
import uk.ac.gla.dcs.team_n.users.IllegalOperationException;
import uk.ac.gla.dcs.team_n.users.LecturerInterface;
import uk.ac.gla.dcs.team_n.users.User;

public class ConcurrentActiveUsersTest {
	
	/**
	 * The system shall support at least 100 different concurrently active users.
	 */
	
	private Data data;
	private ArrayList<User> users;
	
	
	@Before
	public void setUp() throws Exception {
		data = Data.getSingleton();
		users = new ArrayList<User>();
	}
	
	@Test
	public void concurrentActiveUsersTest() throws IllegalOperationException, InterruptedException {
		final class MyThread implements Runnable {
			private LecturerInterface lecturer;
			private MyCampusService myCampusService;

			@Override
			public void run() {
				lecturer = new User(false, false, true, false, data);
				myCampusService = MyCampusService.getSingleton();
				
				try {
					lecturer.importCourseFromMyCampus(myCampusService);
				} catch (IllegalOperationException e) {
				}
				String sessionName = "Lab1";
				synchronized (data) {
					String expectedResult = data.getSession(sessionName).sessionInformation();
				}
				try {
					String result = lecturer.seeSessionSlotsInformation(sessionName);
				} catch (IllegalOperationException e) {
				}
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
				}
				
			}
			
		}
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < 120; i++){
			Thread t = new Thread(new MyThread());
			users.add(new User(false,true,false,false,data));
			threads.add(t);
			t.start();
		}	
		
		assertTrue(Thread.activeCount() >= 101);
		for (Thread t : threads) {
			t.join();
		}
		
		
	}

}
	