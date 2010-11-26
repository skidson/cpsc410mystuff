package ca.ubc.cpsc.mystuff.model;

public class FriendRequest extends Message{
	private int senderID;
	
	public FriendRequest(int id){
		this.senderID = id;
	}
	public void accept(Peer usr){
		usr.addFriend(senderID);
	}
	
}
