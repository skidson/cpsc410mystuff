package ca.ubc.cpsc.mystuff.model;

public class Event {

	private long userID; 
	private	String name; 
	private String username; 
	private String description;
	private int eventID;
	
	public Event(long userID, String name, String username, String description) {
		this.userID = userID;
		this.name = name;
		this.username = username;
		this.description = description;
	}
	
	public int getEventID(){ 
		return eventID;
	}
	
	public void setEventID(int eventID){ 
		this.eventID = eventID;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}
