package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private String text;
	private long authorID;
	private List<Integer> threads;
	private List commentID;
	
	public Comment(){}
	
	public Comment(String text, long authorID, List<Integer> threads,
			List commentID) {
		this.text = text;
		this.authorID = authorID;
		this.threads = threads;
		this.commentID = commentID;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getAuthorID() {
		return authorID;
	}
	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}
	public List<Integer> getThreads() {
		return threads;
	}
	public void setThreads(List<Integer> threads) {
		this.threads = threads;
	}
	public List getCommentID() {
		return commentID;
	}
	public void setCommentID(List commentID) {
		this.commentID = commentID;
	}
	
	
	
}