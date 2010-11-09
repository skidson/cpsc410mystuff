package model;

import java.util.ArrayList;

public class UserLibrary {
	private int count;
	private ArrayList<Item> items;
	
	public UserLibrary(){
		items = null;
	}
	
	public int getCount(){
		return count;
	}
	
	public Item getItem(int itemID){
		return items.get(0); //NOTDONE
	}
	
	public void addItem(int itemID){

	}
	
}
