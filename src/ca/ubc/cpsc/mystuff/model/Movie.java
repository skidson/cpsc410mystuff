package ca.ubc.cpsc.mystuff.model;

public class Movie implements Item {

	private String title;
	private String genre;
	private int duration;
	private int rating;
	private int itemID;
	private Comment comment;

	
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

	public void setRating(int rating) {
		this.rating = rating;

	}

	public void setGenre(String genre) {
		this.genre = genre;

	}

	public void delete() {
		this.delete();

	}

	public void addComment(Comment comment) {
		this.comment.addComment(comment);
	}
	
	public Comment getCommentAt(int index){
		return (this.comment.getCommentAt(index));
	}
	
	public void deleteCommentAt(int index){
		this.comment.deleteCommentAt(index);
	}
	

}
