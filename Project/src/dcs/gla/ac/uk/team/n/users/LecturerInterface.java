package dcs.gla.ac.uk.team.n.users;

import dcs.gla.ac.uk.team.n.attributes.MyCampusService;
import dcs.gla.ac.uk.team.n.enums.SessionEnum;

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
