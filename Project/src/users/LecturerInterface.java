package users;

import enums.SessionEnum;
import attributes.MyCampusService;

public interface LecturerInterface {
	
	public void importCourseFromMyCampus(MyCampusService myCampusService) 
			throws IllegalOperationException;						
	
	public void addSessionToCourse(String sessionName, String coursename)
			throws IllegalOperationException;
	
	public void specifySessionTimeframe(String sessionName, SessionEnum timeframe)
			throws IllegalOperationException;
	
	public String seeSessionSlotsInformation(String sessionName)
			throws IllegalOperationException;

}
