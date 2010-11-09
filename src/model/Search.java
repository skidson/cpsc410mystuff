package model;

public class Search {
	private int duration;
	private int rating;
	private String title;
	private String genre;
	private int itemID;
	
	public Search(int duration, int rating, String title, String genre, int itemID){
		this.duration = duration;
		this.rating = rating;
		this.title = title;
		this.genre = genre;
		this.itemID = itemID;
	}
}
