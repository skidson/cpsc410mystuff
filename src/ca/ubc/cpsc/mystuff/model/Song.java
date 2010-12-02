package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Song{
	private String songID;
	private String title;
	private String genre;
	private int duration;
	private int rating;
	private String artist;
	private ArrayList<Integer> commentID;
	private String URL;
	private String picture;

	public Song(){
		
	}
	
	public Song(String songID, String title, int duration, int rating, int itemID, String newArtist, String URL, String pic) {//, String genre){
		this.songID = songID;
		this.picture = pic;
		this.duration = duration;
		this.rating = rating;
		this.title = title;
		this.artist = newArtist;
		this.URL = URL;
		this.genre = genre;
	}


	public void setPicture(String pic) {
		this.picture = pic;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setArtist(String newArtist) {
		this.artist = newArtist;
	}

	public String getArtist() {
		return this.artist;
	}

	public String getSongID() {
		return songID;
	}

	public String getURL() {
		return this.URL;
	}

	public void setURL(String url){
		this.URL = URL;
	}

	public void setSongID(String songID) {
		this.songID = songID;
	}



	public ArrayList<Integer> getCommentID() {
		return commentID;
	}



	public void setCommentID(ArrayList<Integer> commentID) {
		this.commentID = commentID;
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
