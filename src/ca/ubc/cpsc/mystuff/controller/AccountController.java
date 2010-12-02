package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;
import ca.ubc.cpsc.mystuff.model.UserService;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
@Controller
public class AccountController {
	private UserService userService = new UserService();
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String showAccount() {
		return "account";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String editAccount(Model model) {
		return "account";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String onSubmit(ModelMap model,
			@RequestParam("in_firstName") String firstName, 
			@RequestParam("in_lastName") String lastName,
			@RequestParam("in_email") String email,
			@RequestParam("in_country") String country,
			@RequestParam("in_username") String username,
			@RequestParam("in_password") String password) {
		// TODO verify valid information
		
		/* Generate these IDs here to ensure bean does not contain a service or business logic */
		long userID = userService.generateUserID();
		UserLibrary ul = new UserLibrary(userID);
		
		
		User user = new User("ROLE_USER", firstName, lastName, email, country, username, password, userID);
		userService.saveUser(user);
		UserLibraryService.saveUserLibrary(ul);
		return "registerSuccess";
	}
	
	@RequestMapping("/registerSuccess")
	public String success() {
		return("registerSuccess");
	}
		
	
}