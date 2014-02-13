package users;

import attributes.MyCampusService;

public interface LecturerInterface {
	
	public boolean importCourseFromMyCampus(MyCampusService myCampusService)
						throws IllegalOperationException;

}
