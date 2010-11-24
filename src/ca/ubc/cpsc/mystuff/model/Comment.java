package ca.ubc.cpsc.mystuff.model;

public class Comment {
	private String text;
	private User author;
	
	public Comment(User author, String text){
		this.author = author;
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public User getAuthor(){
		return author;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
}
