package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Movie implements Item {

	private String title;
	private String genre;
	private int duration;
	private int rating;
	private int itemID;
	private ArrayList<Integer> commentID;

	
	public Movie(String title, int duration, int rating, int itemID, String genre){
		this.duration = duration;
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

	public int getDuration() {
		return duration;
	}

	public int getRating() {
		return rating;
	}

	public void setTitle(String title) {
		this.title = title;

	}

	public void setDuration(int duration) {
		this.duration = duration;

	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public ArrayList<Integer> getCommentID() {
		return commentID;
	}

	public void setCommentID(ArrayList<Integer> commentID) {
		this.commentID = commentID;
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

	

}
