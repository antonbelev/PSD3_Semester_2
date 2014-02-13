package users;

import java.util.Date;

public interface AdminInterface {
	
	public void assignRoomToSlot(String roomName, String sessionName)
			throws IllegalOperationException;
	
	
	public void createSlotForSession(Date start, Date end, String courseName, String sessionName)
			throws IllegalOperationException;

}
