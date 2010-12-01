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
		MovieDBWebService s = new MovieDBWebService(search);
		try {
			return(s.getMovies());
		} catch (Exception e) {
			return null;
		}
	}
	
}
