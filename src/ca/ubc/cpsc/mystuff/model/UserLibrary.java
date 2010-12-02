package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class UserLibrary {
	private int itemCount;
	private long ownerID;
	private ArrayList<Integer> viewerID;
	private int id;
	private ArrayList<Integer> movies;
	private ArrayList<Integer> songs;
	
	public void addMovieToLibrary(int movieID){ 
		movies.add(movieID);
	}
	
	public void addSongToLibrary(int songID){ 
		songs.add(songID);
	}
	
	public UserLibrary(long ownerID){ 
		this.itemCount = 0; 
		this.ownerID = ownerID; 
		this.viewerID = null; 
		this.movies = null; 
		this.songs = null;
	}
	
	public UserLibrary(int itemCount, long ownerID,
			ArrayList<Integer> viewerID, int id, ArrayList<Integer> movies,
			ArrayList<Integer> songs) {
		this.itemCount = itemCount;
		this.ownerID = ownerID;
		this.viewerID = viewerID;
		this.id = id;
		this.movies = movies;
		this.songs = songs;
	}
	
	public ArrayList<Integer> getViewerID() {
		return viewerID;
	}
	public void setViewerID(ArrayList<Integer> viewerID) {
		this.viewerID = viewerID;
	}
	
	
	
	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public void setMovies(ArrayList<Integer> movies) {
		this.movies = movies;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCount() {
		return itemCount;
	}
	public void setCount(int count) {
		this.itemCount = count;
	}
	public long getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}
	public ArrayList<Integer> getMovies() {
		return movies;
	}
	public void setmovies(ArrayList<Integer> items) {
		this.movies = items;
	}
	public ArrayList<Integer> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Integer> songs) {
		this.songs = songs;
	}
	public void search(Search query) {
		
	}

}
