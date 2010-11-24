package ca.ubc.cpsc.mystuff.model;

public class Comment {
	private String text;
	private UserBean author;
	
	public Comment(UserBean author, String text){
		this.author = author;
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public UserBean getAuthor(){
		return author;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
}
