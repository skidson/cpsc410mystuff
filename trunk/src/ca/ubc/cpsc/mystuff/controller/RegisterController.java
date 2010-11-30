package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/register")
@SessionAttributes("username")
public class RegisterController {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return("register");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user") User user) {
		userService.add(user);
		return("redirect:/registerSuccess.do");
	}
	
}
