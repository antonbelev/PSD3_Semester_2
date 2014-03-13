package dcs.gla.ac.uk.team.n.users;

import dcs.gla.ac.uk.team.n.attributes.MyCampusService;

public interface AuthenticateInterface {
	
	public boolean authenticate(MyCampusService myCampusService, String username, String password);

}
