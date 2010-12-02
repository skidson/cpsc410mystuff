package ca.ubc.cpsc.mystuff.model;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class MessageService {

	public List<Message> getInbox(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		List<Message> ml =  session.createQuery("select m from User u, Message m where u.userID = m.recipientID and u.username = ?").setString(0,username).list();
	    List<Message> m2 = new ArrayList<Message>();
		for(Message m : ml){ 
	    	m2.add(m);
	    }
		tx.commit(); 
		session.close();
		
		return m2;
	}

	public void deleteMessage(int messageID) {
		// TODO hibernate stuff here
	}
	
	public void saveMessage(Message message) {
		// TODO hibernate stuff here
	}
	
	public Message getMessage(int messageID){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	    Message message = (Message) session.createQuery("from Message" + " where messageID = ?").setInteger(0,messageID).uniqueResult();
		Message m = new Message(message.getText(), message.getRecipientID(), message.getSenderID(), message.getMessageID() , message.getSenderName(), message.getSubject(), message.getDate(), message.getStatus());
		tx.commit(); 
		session.close();
		
		return m;
	}

	public Message getReplyMessage(int messageID){
		Message m = getMessage(messageID);
		Message reply = new Message("", m.getSenderID(), m.getRecipientID(), generateMessageID(), "", "RE:" + m.getSubject(), System.currentTimeMillis(), 0);
		return reply;
	}
	
	public int generateMessageID(){ 
		//TODO: implement generator
		return 123;
	}
}
