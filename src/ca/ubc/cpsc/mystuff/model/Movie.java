package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Movie implements Item {

	private String title;
	private String genre;
	private int rating;
	private int itemID;
	private String image;
	private String overview;

	public Movie() {}
	
	public Movie(String title){
		this.title = title;
	}
	
	public Movie(String title, int rating, int itemID, String genre, String image){
		this.image = image;
		this.rating = rating;
		this.title = title;
		this.genre = genre;
		this.itemID = itemID;
	}
	
	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public int getRating() {
		return rating;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setRating(int rating) {
		this.rating = rating;

	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void delete() {
		this.delete();

	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getOverview() {
		return overview;
	}

}
