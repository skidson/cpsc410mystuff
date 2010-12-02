package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.FriendsService;
import ca.ubc.cpsc.mystuff.model.Message;
import ca.ubc.cpsc.mystuff.model.MessageService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
public class FriendsController {
	UserService userService = new UserService();
	MessageService messageService = new MessageService();
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String loadContent(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = UserService.getUser(username);
		List<Long> friendIDs = user.getFriends();
		List<User> friendsList = new ArrayList<User>();
		
		for(Long id : friendIDs){
			friendsList.add(UserService.getUser(id));
		}

		model.addAttribute("user", user);
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	@RequestMapping("/requestFriend")
	public String sendFriendRequest(@RequestParam("recipient") long recipientID) {
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		String text = "You've received a friend request from " + currentUser.getUsername() +
			"(" + currentUser.getFirstName() + " " + currentUser.getLastName() + 
			"! Click <a href='friendAccept.htm?userID=" + currentUser.getUserID() + ">here</a> to accept.";
		String subject = "Friend request from " + currentUser.getUsername();
		Message friendRequest = new Message(text, recipientID, currentUser.getUserID(),
				messageService.generateMessageID(), currentUser.getUsername(), subject, 
				System.currentTimeMillis(), 0);
		messageService.saveMessage(friendRequest);
		return "redirect:/friends.htm";
	}
	
	@RequestMapping("/acceptFriend")
	public String acceptFriendRequest(@RequestParam("userID") User otherUser) {
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		currentUser.addFriend(otherUser.getUserID());
		otherUser.addFriend(currentUser.getUserID());
		return "redirect:/mailbox.htm";
	}
	
}
