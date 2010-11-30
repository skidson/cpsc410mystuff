package ca.ubc.cpsc.mystuff.model;

import java.util.ArrayList;

public class MainLibrary {
	private ArrayList<UserLibrary> userLibraries;
	
	public void doSearch(Search search){
		for(UserLibrary userLibrary : userLibraries){
			userLibrary.search(search);
		}
	}
}
