package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

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
		UserLibrary ul = UserLibraryService.getUserLibrary(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Integer> movies = ul.getMovies();
		List<Movie> results = new ArrayList<Movie>();
		for(Integer id : movies){
			try {
				results.add(MovieDBWebService.getMovieByID(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("results", results);
		return "media";
	}
	
	@RequestMapping("/addMedia")
	public String addMedia(@RequestParam("itemID") String itemID, Model model) {
		UserLibrary ul = UserLibraryService.getUserLibrary(SecurityContextHolder.getContext().getAuthentication().getName());
		ul.addMovieToLibrary(Integer.parseInt(itemID));
		UserLibraryService.saveUserLibrary(ul);
		return "redirect:/media.htm";
	}
	
	@RequestMapping(value = "/viewMedia")
	public String viewMedia(@RequestParam("itemID") String itemID, Model model){
		Movie movie = null;
		try {
			movie = MovieDBWebService.getMovieByID(Integer.parseInt(itemID));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(movie);
		return "itemPage";
	}
}
