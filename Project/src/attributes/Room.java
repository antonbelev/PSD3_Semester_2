package attributes;

import java.util.HashMap;
import java.util.HashSet;

public class Room {
	
	private String roomName;
	private boolean isAvailable;

	
	public Room(String roomName) {
		this.roomName = roomName;
		this.isAvailable = true;
	}
	
	@Override
	public String toString(){
		return "Room name: " + roomName;
		
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
