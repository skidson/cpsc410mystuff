package ca.ubc.cpsc.mystuff.model;

import org.hibernate.*;
import java.util.*;

public class UserLibraryService {
public static void saveUserLibrary(UserLibrary ul){ 
Session session = HibernateUtil.getSessionFactory().openSession();
   Transaction tx = session.beginTransaction();
   session.saveOrUpdate(ul);
 
   tx.commit();
   session.close();
}
public static UserLibrary getUserLibrary(String username){ 
Session session = HibernateUtil.getSessionFactory().openSession();
   Transaction tx = session.beginTransaction();

   UserLibrary ul =  (UserLibrary) session.createQuery("select ul from User u, UserLibrary ul where u.userID = ul.ownerID and u.username = ?").setString(0,username).uniqueResult();
   UserLibrary ul2 = new UserLibrary(ul.getItemCount(), ul.getOwnerID(), ul.getViewerID(),ul.getId() ,ul.getMovies(), ul.getSongs());
   tx.commit(); 
   session.close();
   
   return ul2;

   
}

}
