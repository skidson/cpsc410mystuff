package ca.ubc.cpsc.mystuff.model;

public class Message {
	private int messageID;
	private String text;
	private int recipientID;
	private int senderID;
	private String senderName;
	private String subject;
	private long date;
	private int status;
	
	/**
	 * 
	 * @param text
	 * @param recipientID
	 * @param senderID
	 * @param messageID
	 * @param senderName
	 * @param subject
	 * @param date
	 * @param status
	 */
	public Message(String text, int recipientID, int senderID, int messageID,
			String senderName, String subject, long date, int status) {
		super();
		this.text = text;
		this.recipientID = recipientID;
		this.senderID = senderID;
		this.messageID = messageID;
		this.senderName = senderName;
		this.subject = subject;
		this.date = date;
		this.status = status;
	}
	
	public int getStatus(){ 
		return status;
	}
	
	public void setStatus(int status){ 
		this.status = status;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

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

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
	

	
	
}
