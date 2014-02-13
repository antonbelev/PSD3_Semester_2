package attributes;

import java.util.HashMap;

public class Student {
	
	private String id;
	private String name;
	private HashMap<String, Course> courses = new HashMap<String, Course>();
	
	public Student(String id, String name, HashMap<String, Course> courses) {
		this.id = id;
		this.name = name;
		this.courses = courses;
	}
	
	@Override
	public String toString(){
		return "StudentID : " + id + " Student name: " + name;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}
}
