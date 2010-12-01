package ca.ubc.cpsc.mystuff.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class MessageService {
	
	public List<Message> getInbox(String username) {
		// TODO hibernate stuff here
		List<Message> inbox = new ArrayList<Message>();
		Message message = new Message();
		message.setText("I like men");
		message.setSenderName("Jeff");
		message.setSubject("My sexual orientation");
		message.setDate(System.currentTimeMillis());
		inbox.add(message);
		return inbox;
	}
	
	public void deleteMessage(int messageID) {
		// TODO hibernate stuff here
	}
}
