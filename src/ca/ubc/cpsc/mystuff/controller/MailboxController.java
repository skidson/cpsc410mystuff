package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/mailbox")
public class MailboxController {
	UserService userService = new UserService();

	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(Model model) {
		return "mailbox";
	}
	
}
