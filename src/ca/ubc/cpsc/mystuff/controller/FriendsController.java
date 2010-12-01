package ca.ubc.cpsc.mystuff.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.FriendsService;
import ca.ubc.cpsc.mystuff.model.User;

@Controller
@RequestMapping("/friends")
public class FriendsController {
	private FriendsService friendService = new FriendsService();
	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = new User(); // NEED TO SEARCH DATA BASE FOR USER HERE
		user.setUsername(username);
		List<Integer> friends = friendService.getFriends();
		model.addAttribute("friends", friends);
		return "friends";
	}
	
	
}
