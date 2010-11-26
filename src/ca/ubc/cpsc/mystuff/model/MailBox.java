package ca.ubc.cpsc.mystuff.model;
import java.util.ArrayList;

public class MailBox {
	private ArrayList<Message> messages;
	
	public MailBox(){
		this.messages = null;
	}
	
	public void addMessage(Message message){
		this.messages.add(message);
	}
	
	public ArrayList<Message> getMessages(){
		return (this.messages);
	}
	
	public void deleteMessage(int index){
		messages.remove(index);
		//could also do message.remove(toBeDeleted) aka pass it a message to be deleted if that
		//is easier
	}
}
