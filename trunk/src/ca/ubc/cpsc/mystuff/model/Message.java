package ca.ubc.cpsc.mystuff.model;

public class Message {
	private String text;
	private User recipient;
	private User sender;
	
	public Message(){
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return (this.text);
	}
	
	public void setRecipient(User recipient){
		this.recipient = recipient;
	}
	
	public User getRecipient(){
		return (this.recipient);
	}
	
	public void setSender(User sender){
		this.sender = sender;
	}
	
	public User getSender(){
		return (this.sender);
	}
	
	
}
