package ca.ubc.cpsc.mystuff.controller;

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
	
	@RequestMapping(value = "/deleteMessage")
	public String deleteMessage(@RequestParam("messageID") String messageID) {
		messageService.deleteMessage(Integer.parseInt(messageID));
		return("redirect:/mailbox.htm");
	}
	
}
