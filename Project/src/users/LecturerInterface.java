package users;

import enums.SessionEnum;
import attributes.MyCampusService;

public interface LecturerInterface {
	
	public boolean importCourseFromMyCampus(MyCampusService myCampusService) 
			throws IllegalOperationException;						
	
	public boolean addSessionToCourse(String sessionName, String coursename)
			throws IllegalOperationException;
	
	public boolean specifySessionTimeframe(String sessionName, SessionEnum timeframe)
			throws IllegalOperationException;
	
	public String seeSessionSlotsInformation(String sessionName)
			throws IllegalOperationException;

}
