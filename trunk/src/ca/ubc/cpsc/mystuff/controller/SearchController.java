package ca.ubc.cpsc.mystuff.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
	private SearchService searchService = new SearchService();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showResults(@RequestParam("searchQuery") String search, Model model) {
		List<Movie> resultList = searchService.doSearch(search);
		model.addAttribute("resultsList", resultList);
		return "searchResults";
	}
		
}