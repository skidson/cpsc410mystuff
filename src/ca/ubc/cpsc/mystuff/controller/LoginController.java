package ca.ubc.cpsc.mystuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.User;

@Controller
@RequestMapping("/login.do")
@SessionAttributes("username")
public class LoginController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return("login");
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user") User user) {
		if (userService.verify(user))
			return("home");
		else
			return("login");
	}
	
}
