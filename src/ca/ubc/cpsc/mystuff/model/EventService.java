package ca.ubc.cpsc.mystuff.model;

import org.hibernate.*;
import java.util.*;

public class EventService {

	public static void saveEvent(Event e){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(e);

		tx.commit();
		session.close();
	}

	public static List<Event> getEventLibrary(String username){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		List<Event> temp = (List<Event>) session.createQuery("select e, from Event e, User u where e.userID = u.userID and u.username = ?").setString(0, username);
		List<Event> eventList = new ArrayList<Event>();
		for(Event e:temp){ 
			Event tmp = new Event(e.getUserID(), e.getName(), e.getUsername(), e.getDescription());
			eventList.add(tmp);
		}
		tx.commit(); 
		session.close();

		return eventList;

	}

}
