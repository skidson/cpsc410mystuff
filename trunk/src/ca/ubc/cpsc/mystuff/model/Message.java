package ca.ubc.cpsc.mystuff.model;

public class Message {
	private String text;
	private int recipientID;
	private int senderID;
	private int messageID;
	
	public Message(){
	}
	
	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return (this.text);
	}

	public int getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(int recipientID) {
		this.recipientID = recipientID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	

	
	
}
