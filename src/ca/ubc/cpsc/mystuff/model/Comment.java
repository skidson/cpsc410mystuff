package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Comment {
	private String text;
	private UserBean author;
	private ArrayList<Comment> threads;
	
	public Comment(UserBean author, String text){
		this.author = author;
		this.text = text;
		this.threads = null;
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
	
	public void addComment(Comment comment){
		threads.add(comment);
	}
	
	public Comment getCommentAt(int index){
		return (threads.get(index));
	}
	
	public void deleteCommentAt(int index){
		threads.remove(index);
	}
	
}
