package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;
import java.util.List;

public class FriendsService {
	private List<Integer> friends = new ArrayList<Integer>();
		
	public void addFriends(int userID){
		this.friends.add(userID);
	}
		
	public List<Integer> getFriends(){
		friends.add(3245);
		friends.add(589430);
		return this.friends;
	}
		
}
