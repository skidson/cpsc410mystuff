package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private String text;
	private long authorID;
	private long itemID; 
	private String type;
	private long commentID;
	
	public Comment(){}

	public Comment(String text, long authorID, long itemID, String type,
			long commentID) {
		super();
		this.text = text;
		this.authorID = authorID;
		this.itemID = itemID;
		this.type = type;
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

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCommentID() {
		return commentID;
	}

	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}

}