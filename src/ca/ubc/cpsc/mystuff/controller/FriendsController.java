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
		long messageID = messageService.generateMessageID();
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		String text = "You've received a friend request from " + currentUser.getUsername() +
			"(" + currentUser.getFirstName() + " " + currentUser.getLastName() + 
			"! Click <a href='acceptFriend.htm?userID=" + currentUser.getUserID() + "?messageID=" + messageID + "'>here</a> to accept.";
		String subject = "Friend request from " + currentUser.getUsername();
		Message friendRequest = new Message(text, recipientID, currentUser.getUserID(),
				messageID, currentUser.getUsername(), subject, 
				System.currentTimeMillis(), 0);
		messageService.saveMessage(friendRequest);
		return "redirect:/friends.htm";
	}
	
	@RequestMapping("/acceptFriend")
	public String acceptFriendRequest(@RequestParam("userID") Long otherUserID, @RequestParam("messageID") Long messageID) {
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		User otherUser = userService.getUser(otherUserID);
		if (currentUser.addFriend(otherUser.getUserID()))
			userService.saveUser(currentUser);
			
		if (otherUser.addFriend(currentUser.getUserID()))
			userService.saveUser(otherUser);
		
		messageService.deleteMessage(messageID);
		
		return "redirect:/mailbox.htm";
	}
	
}
