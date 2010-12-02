package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.MovieDBWebService;
import ca.ubc.cpsc.mystuff.model.SearchService;
import ca.ubc.cpsc.mystuff.model.Song;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/search")
public class SearchController {
	private SearchService searchService = new SearchService();
	private UserService userService = new UserService();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		return "search";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String showResults(@RequestParam("searchQuery") String search, @RequestParam("dropdown_search") String option, Model model) {
		int useResult;
		System.out.println(option);
		if(option.equals("movies")){
			List<Movie> resultList = searchService.movieSearch(search);
			useResult = 0;
			model.addAttribute("resultsList", resultList);
			model.addAttribute("useResult", useResult);
		}else if(option.equals("users")){
			useResult = 2;
			List<User> resultsList = searchService.doUserSearch(search);
			model.addAttribute("resultsList", resultsList);
			model.addAttribute("useResult", useResult);
		}
		else if(option.equals("songs")){
			useResult = 1;
			List<Song> resultsList = searchService.songSearch(search);
			System.out.println(resultsList.get(0).getTitle());
			System.out.println(resultsList.get(0).getURL());
			model.addAttribute("resultsList", resultsList);
			model.addAttribute("useResult", useResult);
		}
			
		model.addAttribute("user", userService.getCurrentUser());
		return "searchResults";
	}
		
	
}