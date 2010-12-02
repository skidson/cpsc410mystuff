package ca.ubc.cpsc.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;

import ca.ubc.cpsc.mystuff.model.Comment;
import ca.ubc.cpsc.mystuff.model.CommentService;
import ca.ubc.cpsc.mystuff.model.Event;
import ca.ubc.cpsc.mystuff.model.EventService;
import ca.ubc.cpsc.mystuff.model.Movie;
import ca.ubc.cpsc.mystuff.model.MovieDBWebService;
import ca.ubc.cpsc.mystuff.model.TrailerDBWebService;
import ca.ubc.cpsc.mystuff.model.User;
import ca.ubc.cpsc.mystuff.model.UserLibrary;
import ca.ubc.cpsc.mystuff.model.UserLibraryService;
import ca.ubc.cpsc.mystuff.model.UserService;

@Controller
public class MediaController {
	private static String ADD_MEDIA_MESSAGE = "{userFirstName} added {mediaName} to their library";
	UserService userService = new UserService();
	
	@RequestMapping(value = "/media", method = RequestMethod.GET)
	public String loadContent(Model model) {
		User currentUser = UserService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		
		UserLibrary ul = UserLibraryService.getUserLibrary(currentUser.getUsername());
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

		model.addAttribute("user", userService.getCurrentUser());
		model.addAttribute("results", results);
		return "media";
	}
	
	@RequestMapping("/addMedia")
	public String addMedia(@RequestParam("itemID") String itemID, Model model) {
		UserService userService = new UserService();
		User currentUser = userService.getCurrentUser();
		UserLibrary ul = UserLibraryService.getUserLibrary(SecurityContextHolder.getContext().getAuthentication().getName());
		
		ul.addMovieToLibrary(Integer.parseInt(itemID));
		Movie addedMovie;
		try {
			addedMovie = MovieDBWebService.getMovieByID(Integer.parseInt(itemID));
			Event event = new Event(currentUser.getUserID(), currentUser.getFirstName(), currentUser.getUsername(), ADD_MEDIA_MESSAGE.replace("{userFirstName}", currentUser.getFirstName()).replace("{mediaName}", addedMovie.getTitle()));
			EventService.saveEvent(event);
		} catch (NumberFormatException e) {

		} catch (Exception e) {

		}
		
		UserLibraryService.saveUserLibrary(ul);

		return "redirect:/media.htm";
	}
	
	@RequestMapping(value = "/viewMedia")
	public String viewMedia(@RequestParam("itemID") String itemID, Model model){
		TrailerDBWebService trailerService = new TrailerDBWebService();
		
		Movie movie = null;
		List<Comment> comments = null;
		try {
			movie = MovieDBWebService.getMovieByID(Integer.parseInt(itemID));
			comments = CommentService.getCommentsForMovie(movie.getItemID());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String trailer = trailerService.getTrailerByMovieName(movie.getTitle());
		
		model.addAttribute("trailer", trailer);

		model.addAttribute("comments", comments);
		model.addAttribute("movie", movie);
		model.addAttribute("user", userService.getCurrentUser());
		
		return "itemPage";
	}
	
	@RequestMapping("/removeMedia")
	public String removeMedia(@RequestParam("itemID") String itemID) {
		UserLibrary userLibrary = UserLibraryService.getUserLibrary(SecurityContextHolder.getContext().getAuthentication().getName());
		userLibrary.removeMovieFromLibrary(Integer.parseInt(itemID));
		UserLibraryService.saveUserLibrary(userLibrary);
		return "redirect:/media.htm";
	}
	
	@RequestMapping("/addComment")
	public String addComment(@RequestParam("itemID") String itemID, Model model) {
		Movie movie = null;
		try {
			movie = MovieDBWebService.getMovieByID((Integer.parseInt(itemID)));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		model.addAttribute("movie", movie);
		return "addComment";
	}
	
	@RequestMapping("/submitComment")
	public String submitComment(@RequestParam("itemID") String itemID, @RequestParam("in_text") String text, Model model){
		Comment c;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = UserService.getUser(username);
		String commentstuff = text;
		long authorID = user.getUserID();
		long commentID = CommentService.generateCommentID();
		c = new Comment(commentstuff, authorID, Long.parseLong(itemID), commentID);
		CommentService.saveComment(c);
		return "redirect:/media.htm";
	}
	
}
