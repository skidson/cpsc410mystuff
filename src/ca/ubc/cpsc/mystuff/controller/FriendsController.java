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
public class FriendsController {
	private UserService userService = new UserService();
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String loadContent(Model model) {
		User user = new User();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user.setUsername(username);
		
		user.addFriend(3245);
		user.addFriend(95803);
		List<Integer> friendsList = user.getFriends();
		model.addAttribute("user", user);
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	
}
