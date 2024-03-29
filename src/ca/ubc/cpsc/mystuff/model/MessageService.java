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

	public void deleteMessage(long messageID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(getMessage(messageID));

		tx.commit();
		session.close();
	}
	
	public void saveMessage(Message message) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(message);

		tx.commit();
		session.close();
	}
	
	public Message getMessage(long messageID){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	    Message message = (Message) session.createQuery("from Message" + " where messageID = ?").setLong(0,messageID).uniqueResult();
		Message m = new Message(message.getText(), message.getRecipientID(), message.getSenderID(), message.getMessageID() , message.getSenderName(), message.getSubject(), message.getDate(), message.getStatus());
		tx.commit();
		session.close();
		
		return m;
	}

	public Message getReplyMessage(long messageID){
		Message m = getMessage(messageID);
		Message reply = new Message("", m.getSenderID(), m.getRecipientID(), generateMessageID(), "", "RE:" + m.getSubject(), System.currentTimeMillis(), 0);
		return reply;
	}
	
	public long generateMessageID(){ 
		//TODO: implement generator
		return System.currentTimeMillis();
	}
}
