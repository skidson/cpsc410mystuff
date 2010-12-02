package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Event;
import ca.ubc.cpsc.mystuff.model.EventService;
import ca.ubc.cpsc.mystuff.model.Message;
import ca.ubc.cpsc.mystuff.model.MessageService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	UserService userService = new UserService();
	MessageService messageService = new MessageService();

	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(Model model) {
		User user = new User();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user.setUsername(username);
		if(username.equalsIgnoreCase("anonymousUser")){
			return "login";
		}
		
		user = userService.getCurrentUser();
		ArrayList<Event> eventList = new ArrayList<Event>();
		for(long friendID : user.getFriends()) {
			eventList.addAll(EventService.getEventLibrary(friendID));
		}
		
		int newCount = 0;
		List<Message> mail = messageService.getInbox(user.getUsername());
		for (Message message : mail) {
			if (message.getStatus() == 0)
				newCount++;
		}
		
		if (newCount != 0) {
			String messageAlert = "You have " + newCount + " new messages in your mailbox!";
			model.addAttribute("messageAlert", messageAlert);
		}
		
		if(eventList != null)
			model.addAttribute("eventList", eventList);
		model.addAttribute("user", userService.getCurrentUser());
		return "home";
	}
	
}
