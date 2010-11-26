package ca.ubc.cpsc.mystuff.model;

public class Search {
	private int duration;
	private int rating;
	private String title;
	private String genre;
	
	public Search(int duration, int rating, String title, String genre){
		this.duration = duration;
		this.rating = rating;
		this.title = title;
		this.genre = genre;
	}
	
	public int getDuration(){
		return (this.duration);
	}
	
	public int getRating(){
		return (this.rating);
	}
	
	public String getTitle(){
		return (this.title);
	}
	
	public String getGenre(){
		return (this.genre);
	}

	
}
