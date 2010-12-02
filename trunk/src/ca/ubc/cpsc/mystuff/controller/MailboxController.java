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
	public String deleteMessage(@RequestParam("messageID") String messageID) {
		messageService.deleteMessage(Integer.parseInt(messageID));
		return("redirect:/mailbox.htm");
	}
	
	@RequestMapping(value = "/replyMessage", method = RequestMethod.GET)
	public String showReplyForm(@RequestParam("messageID") int messageID, Model model){
		Message replyMessage = messageService.getReplyMessage(messageID);
		model.addAttribute("message", replyMessage);
		return "replyMessage";
	}
	
	@RequestMapping(value = "/replyMessage", method = RequestMethod.POST)
	public String sendReply(@ModelAttribute("message") Message message) {
		// TODO verify message
		messageService.saveMessage(message);
		return("redirect:/mailbox.htm");
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	public String showSendForm() {
		return "composeMessage";
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestParam("in_text") String text,
			@RequestParam("in_recipient") String recipient,
			@RequestParam("in_subject") String subject) {
		User sender = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		long recipientID = userService.getUserID(recipient);
		
		Message message = new Message(text, recipientID, sender.getUserID(), 
				messageService.generateMessageID(), sender.getUsername(), subject, System.currentTimeMillis(), 0);
		return "redirect:/mailbox.htm";
	}
}
