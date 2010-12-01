package ca.ubc.cpsc.mystuff.model;
import java.util.List;

public class searchService {
	private List<Movie> resultList;
	
	public void addResults(Movie movie){
		this.resultList.add(movie);
	}
	
	public List<Movie> getResultList(){
		return this.resultList;
	}
	
}
