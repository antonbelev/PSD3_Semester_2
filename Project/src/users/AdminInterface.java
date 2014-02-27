package users;

import java.util.Date;

public interface AdminInterface extends AuthenticateInterface {
	
	public void assignRoomToSlot(String roomName, String sessionName)
			throws IllegalOperationException;
	
	
	public void createSlotForSession(Date start, Date end, String sessionName)
			throws IllegalOperationException;

}
