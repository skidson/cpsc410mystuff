package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login.do")
@SessionAttributes("username")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return("login");
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (verify(username, password))
			return("home.do");
		else
			return("login");
	}
	
	private boolean verify(String username, String password) {
		// do database things and stuff
		return true;
	}
	
}
