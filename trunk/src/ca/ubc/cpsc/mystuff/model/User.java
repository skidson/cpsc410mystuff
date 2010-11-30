package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class User {
	private int userType; 
	private int rating;
	private String firstName;
	private String lastName;
	private String country;
	private String userName;
	private String password;
	private MailBox mailbox;
	private int userID;
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	
	public User() {
	}
	
	public void setUserType(int type){ 
		this.userType = type; 
	}
	
	public int getUserType(){ return userType; }
	
	public void setUsername(String username){
		this.userName = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUsername() { return userName; }
	public String getPassword() { return password; }
	
	public void addFriend(int userID){
		friends.add(userID);
	}
	
	public void addFriend(FriendRequest request){
		request.accept(this);
	}
	
	public void removeFriend(int userID){
		
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getCountry(){
		return country;
	}
	
	public int getRating(){
		return rating;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public void setUserID(int id){
		this.userID = id;
	}
	
	public int getUserID(){
		return (this.userID);
	}
	

}
