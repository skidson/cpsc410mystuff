package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class Comment {
	private String text;
	private int author;
	private ArrayList<Integer> threads;
	private int commentID;
	

	public Comment(int author, String text){
		this.author = author;
		this.text = text;
		this.threads = null;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public ArrayList<Integer> getThreads() {
		return threads;
	}

	public void setThreads(ArrayList<Integer> threads) {
		this.threads = threads;
	}


	
}
