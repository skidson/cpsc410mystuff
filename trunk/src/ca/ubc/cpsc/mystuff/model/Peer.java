package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Peer extends UserBean {
	private int rating;
	private String firstName;
	private String lastName;
	private String country;
	private MailBox mailbox;
	private int userID;
	private ArrayList<Peer> friends = new ArrayList<Peer>();
	
	public Peer() {
	}
	
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
