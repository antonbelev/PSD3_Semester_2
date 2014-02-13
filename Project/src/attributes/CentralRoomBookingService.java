package attributes;

import java.util.HashMap;

public class CentralRoomBookingService {
	
	private HashMap<String, Room> freeRooms;
	
	private static CentralRoomBookingService centralRoomBookingServiceInstance;
	
	public CentralRoomBookingService(){
		freeRooms = new HashMap<String, Room>();
	}
	
	public static CentralRoomBookingService getSingleton() {
		if (centralRoomBookingServiceInstance == null) {
			centralRoomBookingServiceInstance = new CentralRoomBookingService();
		}
		return centralRoomBookingServiceInstance;
	}
	
	
	
	

}
