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
	
	public static User getUser(String username){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    User user = (User) session.createQuery(
                "from User" + " where username = ?").setString(0,username).uniqueResult();
	    ArrayList<Long> L = new ArrayList( user.getFriends());
	    user.setFriends(L);

	    tx.commit();
	    session.close();
	    
	    return user;
	}
	
	public List<User> getUsersByFirstName(String firstname){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    List<User> temp = (List<User>) session.createQuery("from User" + " where firstName = ?").setString(0,firstname).list();
	    List<User> userList = new ArrayList<User>();
	    for(User u: temp){ 
	    	User tmp = new User(u.getauthority(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCountry(),u.getUsername(),u.getPassword(), u.getUserID());
	    	tmp.setFriends(u.getFriends());
	    	userList.add(tmp);
	    }
	    
	    tx.commit();
	    session.close();
	    
	    return userList;
	}
	
	public static User getUser(long userID){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    User user = (User) session.createQuery(
                "from User" + " where userID = ?").setLong(0,
                userID).uniqueResult();
	    ArrayList<Long> L = new ArrayList(user.getFriends());
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
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    User user = (User) session.createQuery(
                "from User" + " where username = ?").setString(0,username).uniqueResult();
	    long userID = user.getUserID();
	    tx.commit();
	    session.close();
	    
	    return userID;
	}
	
	
	public long generateUserID() {
		// TODO: Change way of generating user id
		return System.currentTimeMillis();
	}
}