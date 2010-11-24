package ca.ubc.cpsc.mystuff.model;

public class User {
	private String userID;
	private String password;
	private String[] friends;

	public User() {
	}

	public void setUserID(String userID){
		this.userID = userID;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
}
