package ca.ubc.cpsc.mystuff.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.MovieDBWebService;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;

@Controller
public class MediaController {
	
	@RequestMapping(value = "/media", method = RequestMethod.GET)
	public String loadContent(Model model) {
		return "media";
	}
	
	@RequestMapping("/addMedia")
	public String addMedia(@RequestParam("itemID") String itemID, Model model) {

		
		UserLibrary ul = UserLibraryService.getUserLibrary(SecurityContextHolder.getContext().getAuthentication().getName());
		ul.addMovieToLibrary(Integer.parseInt(itemID));
		UserLibraryService.saveUserLibrary(ul);
		return "Movie has been added to library";
	}
	
}
