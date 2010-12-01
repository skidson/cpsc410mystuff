package ca.ubc.cpsc.mystuff.model;
import java.util.ArrayList;
import java.util.List;

public class SearchService {
	private List<Movie> resultList;
	
	public void addResults(Movie movie){
		this.resultList.add(movie);
	}
	
	public List<Movie> getResultList(){
		return this.resultList;
	}
	
	public void setResultList(List<Movie> resultList){
		this.resultList = resultList;
	}
	
	public List<Movie> doSearch(String search) {
		// do hibernate stuff
		Movie movie= new Movie();
		movie.setTitle("Iron Man 2");
		movie.setRating(4);
		movie.setImage("http://www.moviesonline.ca/movie-gallery/albums/userpics//poster_ironman-2.jpg");
		movie.setOverview("The movie owns, but more importantly, it works!");
		List<Movie> resultsList = new ArrayList<Movie>();
		resultsList.add(movie);
		resultsList.add(movie);
		return(resultsList);
	}
	
}

//public Movie(String title, int duration, int rating, int itemID, String genre){
//	this.duration = duration;
//	this.rating = rating;
//	this.title = title;
//	this.genre = genre;
//	this.itemID = itemID;
//}