package ca.ubc.cpsc.mystuff.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.SearchService;

@Controller
public class SearchController {
	private SearchService searchService = new SearchService();

	@RequestMapping("/search")
	public String showResults(@RequestParam("searchQuery") String search, Model model) {
		List<Movie> resultList = searchService.doSearch(search);
		model.addAttribute("resultsList", resultList);
		return "searchResults";
	}
		
}