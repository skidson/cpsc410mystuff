package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadContent() {
		return("home");
	}
	
	private void showNewsFeed() {
		// do database things and stuff
		
	}
	
}