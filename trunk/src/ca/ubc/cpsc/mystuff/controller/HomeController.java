package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home*")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadContent() {
		return new ModelAndView("home");
	}
	
	private void showNewsFeed() {
		// do database things and stuff
		
	}
	
}
