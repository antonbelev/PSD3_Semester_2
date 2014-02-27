package users;

import attributes.MyCampusService;

public interface AuthenticateInterface {
	
	public boolean authenticate(MyCampusService myCampusService, String username, String password);

}
