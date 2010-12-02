package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class UserLibrary {
	private int itemCount;
	private long ownerID;
	private List<Integer> viewerID;
	private int id;
	private List<Integer> movies;
	private List<Integer> songs;
	
	public UserLibrary(){}
	
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
			List<Integer> viewerID, int id, List<Integer> movies,
			List<Integer> songs) {
		this.itemCount = itemCount;
		this.ownerID = ownerID;
		this.viewerID = viewerID;
		this.id = id;
		this.movies = new ArrayList<Integer>(movies);
		this.songs = new ArrayList<Integer>(songs);
	}
	
	public List<Integer> getViewerID() {
		return viewerID;
	}
	public void setViewerID(List<Integer> viewerID) {
		this.viewerID = viewerID;
	}
	
	
	
	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public void setMovies(List<Integer> movies) {
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
	public List<Integer> getMovies() {
		return movies;
	}
	public void setmovies(List<Integer> items) {
		this.movies = items;
	}
	public List<Integer> getSongs() {
		return songs;
	}
	public void setSongs(List<Integer> songs) {
		this.songs = songs;
	}
	public void search(Search query) {
		
	}

}
