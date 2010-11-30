package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class UserLibrary {
	private int count;
	private int ownerID;
	private ArrayList<Integer> viewerID;
	private int id;
	private ArrayList<Integer> items;
	
	public ArrayList<Integer> getViewerID() {
		return viewerID;
	}
	public void setViewerID(ArrayList<Integer> viewerID) {
		this.viewerID = viewerID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	public ArrayList<Integer> getItems() {
		return items;
	}
	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}
	
	public void search(Search query) {
		
	}

}
