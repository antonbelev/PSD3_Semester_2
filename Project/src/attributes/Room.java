package attributes;

import java.util.HashMap;
import java.util.HashSet;

public class Room {
	
	private String roomName;
	private boolean isAvailable;
	private HashMap<String, Session> sessions = new HashMap<String, Session>();
	
	public Room(String roomName, HashMap<String, Session> sessions) {
		this.roomName = roomName;
		this.sessions = sessions;
		this.isAvailable = true;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public HashMap<String, Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashMap<String, Session> sessions) {
		this.sessions = sessions;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
