package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private UserService userService = new UserService();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(ModelMap model,
			@RequestParam("in_firstName") String firstName, 
			@RequestParam("in_lastName") String lastName,
			@RequestParam("in_email") String email,
			@RequestParam("in_country") String country,
			@RequestParam("in_username") String username,
			@RequestParam("in_password") String password) {
		// TODO verify valid information
		int mailboxID = userService.generateMailboxID();
		int userID = userService.generateUserID();
		User user = new User("ROLE_USER", firstName, lastName, email, country, username, password, mailboxID, userID);
		userService.saveUser(user);
		return "registerSuccess"; // TODO how to get outside security?
	}

}