package ca.ubc.cpsc.mystuff.model;

import java.util.List;

public class User {
	private int userType; 
	private int rating;
	private String firstName;
	private String lastName;
	private String country;
	private String username;
	private String password;
	private int mailboxID;
	private int userID;
	private List friends;
	
	public User(){}
	
	public User(int userType, 
			int rating, 
			String firstName, 
			String lastName,
			String country, 
			String username,
			String password,
			int mailboxID, 
			int userID, 
			List friends){
		this.userType = userType; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.country = country;
		this.username = username; 
		this.password = password; 
		this.mailboxID = mailboxID; 
		this.userID = userID;
		this.friends = friends;
	}
	
	public void setFriends(List f){ 
		this.friends = f;
	}
	
	
	
	public List getFriends(){ 
		return this.friends;
	}
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMailboxID() {
		return mailboxID;
	}
	public void setMailboxID(int mailboxID) {
		this.mailboxID = mailboxID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
