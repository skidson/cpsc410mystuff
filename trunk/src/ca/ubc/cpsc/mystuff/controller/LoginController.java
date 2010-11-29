package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login.do")
@SessionAttributes("username")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (verify(username, password))
			return("home");
		else
			return("login");
	}
	
	private boolean verify(String username, String password) {
		// do database things and stuff
		return true;
	}
	
}
