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
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	UserService userService = new UserService();

	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(@RequestParam("userID") long userID, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = UserService.getUser(username);
		Random random = new Random();
		User person = UserService.getUser(userID);
		UserLibrary ul = UserLibraryService.getUserLibrary(person.getUsername());
		List<Integer> movies = ul.getMovies();
		Movie movie = null;
		try {
			movie = MovieDBWebService.getMovieByID(movies.get(random.nextInt(movies.size())));} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("user", user);
		model.addAttribute("movie", movie);
		model.addAttribute("person", person);
		return "profile";
	}
	
}
