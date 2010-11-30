package ca.ubc.cpsc.mystuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@SessionAttributes
@RequestMapping("/login")
public class LoginController {
	private UserService userService = new UserService();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user") User user) {
		if (userService.verify(user))
			return("home");
		else
			return("login");
	}
	
}
