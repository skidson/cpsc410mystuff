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
	
	public static List<Comment> getCommentsForMovie(int movieID){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		List<Comment> tempList =  (List<Comment>) session.createQuery("select c from Comment c where c.itemID = ?").setInteger(0,movieID).list();
		List<Comment> commentList = new ArrayList<Comment>();
		for(Comment c : tempList){
			Comment tmp = new Comment(c.getText(), c.getAuthorID(), c.getItemID(), c.getType(), c.getCommentID());
			commentList.add(tmp);
		}
		
		tx.commit(); 
		session.close();

		return commentList;


	}

}
