package ca.ubc.cpsc.mystuff.model;

import org.hibernate.*;
import java.util.*;

public class CommentService {

	public static void saveComment(Comment c){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(c);
		tx.commit();
		session.close();
	}
	
//	public static List<Comment> getCommentsForMovie(int movieID){ 
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//
//		List<Comment> tempList =  (List<Comment>) session.createQuery("select c from Comment c where c.itemID = ?").setInteger(0,movieID).list();
//		
//		For(Comment c: tempList){
//			
//		}
//		
//		tx.commit(); 
//		session.close();
//
//		return ul2;
//
//
//	}

}
