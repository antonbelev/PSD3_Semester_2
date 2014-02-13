package attributes;

import java.util.HashMap;

public class MyCampusService {
	
	private HashMap<String, Course> courses;
	
	private static MyCampusService myCampuseInstance;

	public MyCampusService() {
		courses = new HashMap<String, Course>();
	}

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}
	
	public static MyCampusService getSingleton() {
		if (myCampuseInstance == null) {
			myCampuseInstance = new MyCampusService();
		}
		return myCampuseInstance;
	}
	
	
}
