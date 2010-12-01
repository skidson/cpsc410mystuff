package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
public class RegisterController {
	private UserService userService = new UserService();
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		try {
			boolean wtf = ((User)model.get("user")).getUsername().equals("it works");
			return("test");
		} catch (NullPointerException e) {
			User user = new User();
			user.setUsername("it works");
			model.addAttribute(user);
			return("register");
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String onSubmit(ModelMap model, BindingResult result) {
		try {
			boolean wtf = ((User)model.get("user")).getUsername().equals("it works");
			return("test");
		} catch (NullPointerException e) {
			User user = new User();
			user.setUsername("it works");
			model.addAttribute(user);
			return("register");
		}
	}
	
	@RequestMapping(value = "/test")
	public String onTest(ModelMap model, BindingResult result) {
		return "test";
	}
	
}