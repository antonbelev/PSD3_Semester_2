package attributes;

import java.util.HashSet;

public class Room {
	
	private String roomName;
	private HashSet<Session> sessions = new HashSet<Session>();
	
	public Room(String roomName, HashSet<Session> sessions) {
		this.roomName = roomName;
		this.sessions = sessions;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public HashSet<Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashSet<Session> sessions) {
		this.sessions = sessions;
	}
}
