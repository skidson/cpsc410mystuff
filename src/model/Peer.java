package model;

public class Peer extends User {
	private int rating;
	private String firstName;
	private String lastName;
	private String country;
	private MailBox mailbox;
	
	public Peer() {
	}
	
	public void addFriend(int userID){
		
	}
	
	public void addFriend(FriendRequest request){
		request.accept();
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
	

}
