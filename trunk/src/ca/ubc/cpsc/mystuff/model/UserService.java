package ca.ubc.cpsc.mystuff.model;

import org.hibernate.*;
import java.util.*;

public class UserService {
	
	public static void saveUser(User user){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(user);
	    tx.commit();
	    session.close();
	}
	
	public static User getUser(int userID){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    User user = (User) session.createQuery(
                "from User" + " where userID = ?").setInteger(0,
                userID).uniqueResult();
	    ArrayList<Integer> L = new ArrayList( user.getFriends());
	    user.setFriends(L);
	    
//	    User user = (User) session.get(User.class, userID);
	    
	    
	    tx.commit();
	    session.close();
	    
	    return user;
	}
	
	
	
	public void delete() {
		// TODO hibernate stuff here
	}
	
	public long getUserID(String username) {
		// TODO hibernate stuff here
		return 1337;
	}
	
	public int generateMailboxID() {
		// TODO hibernate stuff here
		return 1337;
	}
	
	public long generateUserID() {
		// TODO: Change way of generating user id
		return System.currentTimeMillis();
	}
}