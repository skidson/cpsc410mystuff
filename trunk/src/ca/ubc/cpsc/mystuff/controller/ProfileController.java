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
		Random random = new Random();
		User user = UserService.getUser(userID);
		UserLibrary ul = UserLibraryService.getUserLibrary(user.getUsername());
		List<Integer> movies = ul.getMovies();
		Movie movie = null;
		try {
			movie = MovieDBWebService.getMovieByID(movies.get(random.nextInt(movies.size())));} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("movie", movie);
		model.addAttribute("user", user);
		return "profile";
	}
	
}
