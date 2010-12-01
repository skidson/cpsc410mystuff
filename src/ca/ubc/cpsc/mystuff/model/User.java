package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String authority; 
	private int rating;
	private String firstName;
	private String lastName;
	private String country;
	private String username;
	private String password;
	private String email;
	private int mailboxID;
	private int userID;
	private List<Integer> friends;
	
	public User(){}
	
	public User(String authority,
			String firstName, 
			String lastName,
			String email,
			String country, 
			String username,
			String password,
			int mailboxID,
			int userID){
		this.authority = authority;
		this.rating = 0;
		this.firstName = firstName; 
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.username = username; 
		this.password = password; 
		this.mailboxID = mailboxID; 
		this.userID = userID;
		this.friends = new ArrayList<Integer>();
	}
	
	public void setFriends(List<Integer> friends){ 
		this.friends = friends;
	}
	
	public List<Integer> getFriends(){ 
		return this.friends;
	}
	
	public String getUserType() {
		return authority;
	}
	public void setUserType(String userType) {
		this.authority = userType;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	
}
