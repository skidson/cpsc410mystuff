package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private String text;
	private long authorID;
	private List<Long> threads;
	private Long commentID;
	
	public Comment(){}
	
	public Comment(String text, long authorID, List<Long> threads,
			Long commentID) {
		super();
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
	public List<Long> getThreads() {
		return threads;
	}
	public void setThreads(List<Long> threads) {
		this.threads = threads;
	}
	public Long getCommentID() {
		return commentID;
	}
	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}
	
	
}