package ca.ubc.cpsc.mystuff.model;

public class FriendRequest extends Message{
	private long senderID;
	private long receiverID;
	private int requestID;
	public long getSenderID() {
		return senderID;
	}
	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}
	public long getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(long receiverID) {
		this.receiverID = receiverID;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	
	
}
