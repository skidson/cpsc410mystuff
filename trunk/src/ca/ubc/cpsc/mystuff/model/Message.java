package ca.ubc.cpsc.mystuff.model;

public class Message {
	private long messageID;
	private String text;
	private long recipientID;
	private long senderID;
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
	public Message(String text, long recipientID, long senderID, long messageID,
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
	
	public long getMessageID() {
		return messageID;
	}

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return (this.text);
	}

	public long getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(long recipientID) {
		this.recipientID = recipientID;
	}

	public long getSenderID() {
		return senderID;
	}

	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
	

	
	
}
