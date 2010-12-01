package ca.ubc.cpsc.mystuff.model;

public interface Item {

	public String getTitle();
	public String getGenre();
	public int getRating();
	public void setTitle(String title);
	public void setRating(int rating);
	public void setGenre(String genre);
	public void delete();
	public void addComment(Comment comment);
}
