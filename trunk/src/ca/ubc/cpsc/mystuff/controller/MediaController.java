package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;

@Controller
public class MediaController {
	
	@RequestMapping(value = "/media", method = RequestMethod.GET)
	public String loadContent(Model model) {
		return "media";
	}
	
	@RequestMapping("/addMedia")
	public String addMedia(@RequestParam("itemID") String itemID, Model model) {
		Movie movie = new Movie();
		movie.setItemID(Integer.parseInt(itemID));
		model.addAttribute("movie", movie);
		return "media";
	}
	
}
