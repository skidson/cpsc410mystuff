package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.MovieDBWebService;
import ca.ubc.cpsc.mystuff.model.SearchService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;

@Controller
@RequestMapping("/search")
public class SearchController {
	private SearchService searchService = new SearchService();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "search";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String showResults(@RequestParam("searchQuery") String search, @RequestParam("dropdown_search") String option, Model model) {
		Random random = new Random();
		int useResult;
		System.out.println(option);
		if(option.equals("movies")){
			List<Movie> resultList = searchService.movieSearch(search);
			useResult = 0;
			model.addAttribute("resultsList", resultList);
			model.addAttribute("useResult", useResult);
		}else if(option.equals("users")){
			useResult = 1;
			List<User> resultList = searchService.doUserSearch(search);
			List<Movie> movies = new ArrayList<Movie>();
			for(User user : resultList){
				UserLibrary ul = UserLibraryService.getUserLibrary(user.getUsername());
				List<Integer> moviesID = ul.getMovies();
				try {
					movies.add(MovieDBWebService.getMovieByID(moviesID.get(random.nextInt(moviesID.size()))));
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			model.addAttribute("movies", movies);
			model.addAttribute("resultList", resultList);
			model.addAttribute("useResult", useResult);
		}
			

		return "searchResults";
	}
		
	
}