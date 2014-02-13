package users;

import java.util.Date;

public interface AdminInterface {
	
	public boolean assignRoomToSlot(String roomName, String sessionName)
			throws IllegalOperationException;
	
	
	public boolean createSlotForSession(Date start, Date end, String courseName, String sessionName)
			throws IllegalOperationException;

}
