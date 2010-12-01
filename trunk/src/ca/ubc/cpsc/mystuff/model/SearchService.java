package ca.ubc.cpsc.mystuff.model;
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
	
	public void doSearch(Search search) {
		
	}
	
}
