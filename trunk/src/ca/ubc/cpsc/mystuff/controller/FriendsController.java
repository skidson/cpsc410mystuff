package ca.ubc.cpsc.mystuff.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.FriendsService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/friends")
public class FriendsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = UserService.getUser(username); // NEED TO SEARCH DATA BASE FOR USER HERE
		List<Integer> friends = user.getFriends();
		model.addAttribute("friends", friends);
		return "friends";
	}
	
}
