package ca.ubc.cpsc.mystuff.model;

public class FriendRequest extends Message{
	private int senderID;
	private int receiverID;
	private int requestID;
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	public int getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
	

	
}
