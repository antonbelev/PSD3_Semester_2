package uk.ac.gla.dcs.team_n.users;

import uk.ac.gla.dcs.team_n.attributes.MyCampusService;
import uk.ac.gla.dcs.team_n.enums.SessionEnum;

public interface LecturerInterface extends AuthenticateInterface {
	
	public void importCourseFromMyCampus(MyCampusService myCampusService) 
			throws IllegalOperationException;						
	
	public void addSessionToCourse(String sessionName, String coursename)
			throws IllegalOperationException;
	
	public void specifySessionTimeframe(String sessionName, SessionEnum timeframe)
			throws IllegalOperationException;
	
	public String seeSessionSlotsInformation(String sessionName)
			throws IllegalOperationException;
	
}
