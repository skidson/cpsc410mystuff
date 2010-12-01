package ca.ubc.cpsc.mystuff.model;

public class Search {
	private String search;
	
	public Search() {}
	
	public Search(String search){
		this.setSearch(search);
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearch() {
		return search;
	}
	
}
