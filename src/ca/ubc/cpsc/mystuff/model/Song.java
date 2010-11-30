package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Song{
	private int songID;
	private String title;
	private String genre;
	private int duration;
	private int rating;
	private ArrayList<Integer> commentID;

	
	public Song(int songID, String title, int duration, int rating, int itemID, String genre){
		this.songID = songID;
		this.duration = duration;
		this.rating = rating;
		this.title = title;
		this.genre = genre;
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

	public void setRating(int rating) {
		this.rating = rating;

	}

	public void setGenre(String genre) {
		this.genre = genre;

	}

	public void delete() {
		this.delete();

	}



	}
