package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ca.ubc.cpsc.mystuff.model.Search;
import ca.ubc.cpsc.mystuff.model.SearchService;

@Controller
public class SearchController {
	private SearchService searchService = new SearchService();

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView onSearch(@RequestParam("searchQuery") String query) {
		Search search = new Search(query);
		
	}
}