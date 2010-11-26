package ca.ubc.cpsc.mystuff.model;

public class Message {
	private String text;
	private Peer recipient;
	private Peer sender;
	
	public Message(){
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return (this.text);
	}
	
	public void setRecipient(Peer recipient){
		this.recipient = recipient;
	}
	
	public Peer getRecipient(){
		return (this.recipient);
	}
	
	public void setSender(Peer sender){
		this.sender = sender;
	}
	
	public Peer getSender(){
		return (this.sender);
	}
	
	
}
