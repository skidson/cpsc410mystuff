package ca.ubc.cpsc.mystuff.model;

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
	
	public ArrayList<Item> search(Search search){
		ArrayList<Item> matchedItems = new ArrayList<Item>();
		for(Item item : items){
			if (item.getDuration() == search.getDuration())
				matchedItems.add(item);
			else if (item.getGenre().equals(search.getGenre()))
				matchedItems.add(item);
			else if (item.getRating() == search.getRating())
				matchedItems.add(item);
			else if (item.getTitle() == search.getTitle())
				matchedItems.add(item);		
		}
		return matchedItems;
	}
}
