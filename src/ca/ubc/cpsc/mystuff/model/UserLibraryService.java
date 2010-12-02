package ca.ubc.cpsc.mystuff.model;

import org.hibernate.*;
import java.util.*;

public class UserLibraryService {
	
	public static void saveUserLibrary(UserLibrary ul){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(ul);
	    tx.commit();
	    session.close();
	}
	
	public static UserLibrary getUserLibrary(String username){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    User user = (User) session.createQuery(
                "from User" + " where username = ?").setString(0,username).uniqueResult();
	    ArrayList<Integer> L = new ArrayList( user.getFriends());
	    user.setFriends(L);

	    tx.commit();
	    session.close();
	    
	    UserLibrary ul = (UserLibrary) session.createQuery("from userlibrary" + " where ownerid = ?").setLong(0,user.getUserID()).uniqueResult();
	    return ul;
	}
	
	public void delete() {
		// TODO hibernate stuff here
	}
	
}