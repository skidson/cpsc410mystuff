package ca.ubc.cpsc.mystuff.controller;

import org.springframework.security.core.context.SecurityContextHolder;
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
	public String showAccount(Model model) {
		model.addAttribute("user", userService.getCurrentUser());
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
		// verify valid information
		boolean synName, synPass, synCountry, synEmail, synFName, synLName, valid = true;
		synName = isdigornum(username);
		synPass = isdigornum(password);
		synCountry = isdigornum(country);
		synEmail = isdigornum(email);
		synFName = isdigornum(firstName);
		synLName = isdigornum(lastName);
		
		if (!(synName && synPass && synCountry && synEmail && synFName && synLName)){
			return "redirect:/register.htm?error=true";
		}
		
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
	
	@RequestMapping(value = "/updateInfo" , method = RequestMethod.POST)
	public String updateInfo(@RequestParam("newPassword") String password, Model model){
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		currentUser.setPassword(password);
		userService.saveUser(currentUser);
		return("redirect:/account.htm");
	}
		
	public static boolean isdigornum(String a){
		char[] characters = a.toCharArray();
		for (int i = 0; i< characters.length; i++){
			if (Character.isLetterOrDigit(characters[i]))
			{
			return false;
			}
		}
		if (a.equals("")) {
			return false;
		}
		return true;
}
}