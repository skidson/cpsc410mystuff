package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Event;
import ca.ubc.cpsc.mystuff.model.EventService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	UserService userService = new UserService();

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
		
		if(eventList != null)
			model.addAttribute("eventList", eventList);
		model.addAttribute("user", userService.getCurrentUser());
		return "home";
	}
	
}
