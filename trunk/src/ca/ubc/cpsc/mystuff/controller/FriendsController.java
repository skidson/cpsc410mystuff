package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
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
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String loadContent(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = UserService.getUser(username);
		user.addFriend(UserService.getUser("skidson").getUserID());
		List<Long> friendIDs = user.getFriends();
		List<User> friendsList = new ArrayList<User>();
		
		for(Long id : friendIDs){
			friendsList.add(UserService.getUser(id));
		}

		model.addAttribute("user", user);
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	
}
