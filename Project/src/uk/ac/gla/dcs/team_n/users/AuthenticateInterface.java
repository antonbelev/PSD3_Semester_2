package uk.ac.gla.dcs.team_n.users;

import uk.ac.gla.dcs.team_n.attributes.MyCampusService;

public interface AuthenticateInterface {
	
	public boolean authenticate(MyCampusService myCampusService, String username, String password);

}
