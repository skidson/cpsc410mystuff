package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Message;
import ca.ubc.cpsc.mystuff.model.MessageService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
public class MailboxController {
	MessageService messageService = new MessageService();
	UserService userService = new UserService();

	@RequestMapping(value = "/mailbox", method = RequestMethod.GET)
	public String loadContent(Model model) {
		User user = new User();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user.setUsername(username);
		
		List<Message> messageList = messageService.getInbox(username);
		
		model.addAttribute("user", user);
		model.addAttribute("messageList", messageList);
		return "mailbox";
	}
	
	@RequestMapping("/deleteMessage")
	public String deleteMessage(@RequestParam("messageID") Long messageID) {
		messageService.deleteMessage(messageID);
		return("redirect:/mailbox.htm");
	}
	
	@RequestMapping(value = "/replyMessage", method = RequestMethod.GET)
	public String showReplyForm(@RequestParam("messageID") long messageID, Model model){
		Message reply = messageService.getReplyMessage(messageID);
		String replyName = messageService.getMessage(messageID).getSenderName();
		messageService.getMessage(messageID).setStatus(1);
		model.addAttribute("reply", reply);
		model.addAttribute("replyName", replyName);
		model.addAttribute("user", userService.getCurrentUser());
		return "composeMessage";
	}
	
	@RequestMapping(value = "/composeMessage")
	public String showSendForm(@RequestParam("username") String username, Model model) {
		model.addAttribute("replyName", username);
		return "composeMessage";
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestParam("in_text") String text,
			@RequestParam("in_recipient") String recipient,
			@RequestParam("in_subject") String subject) {
		// TODO validate fields
		User sender = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		long recipientID = userService.getUserID(recipient);
		
		Message message = new Message(text, recipientID, sender.getUserID(), 
				messageService.generateMessageID(), sender.getUsername(), subject, System.currentTimeMillis(), 0);
		messageService.saveMessage(message);
		return "redirect:/mailbox.htm";
	}
	
}
