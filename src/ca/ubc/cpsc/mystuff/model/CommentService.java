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
	
	public static List<Comment> getCommentsForMovie(String movieID){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Comment c =  (Comment) session.createQuery("select c from Comment c, Movie m where m.itemID = ul.ownerID and u.username = ?").setString(0,username).uniqueResult();
		UserLibrary ul2 = new UserLibrary(ul.getItemCount(), ul.getOwnerID(), ul.getViewerID(),ul.getId() ,ul.getMovies(), ul.getSongs());
		tx.commit(); 
		session.close();

		return ul2;


	}

}
