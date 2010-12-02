package ca.ubc.cpsc.mystuff.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

import ca.ubc.cpsc.mystuff.model.WebFiles;

public class LastFMWebService {


	
	public static ArrayList<Song> getSongs(String track) throws MalformedURLException, IOException {

		ArrayList<Song> songArray = new ArrayList<Song>();
		
		String apiKey = "54a95dbf1f737c65aa382725431d8aab";
		//String appSecret = "4ef85cb5b8646ae31e7dfa7c74c5b3ee";
		String art = "";
		String lim = "10";
		String search = "";
		String limit = "";
		String artSearch = ""; 
		
		if (!lim.equals(null)) 
			limit = lim;
		if (!search.equals(null))
			search = track;
		if (!art.equals(null))
			artSearch = art;
		if(search.equals(null))
		{
			throw new IOException();
		}
		
		search = search.replace(" ", "+");
		limit = limit.replace(" ", "+");
		artSearch = artSearch.replace(" ", "+");		
		
		WebFiles file   = new WebFiles( "http://ws.audioscrobbler.com/2.0/?method=track.search" + 
										"&track=" + search +
										"&limit=" + limit +
										"&artist=" + artSearch +
										"&api_key=" + apiKey);

		Object content = file.getContent( );
		String results = (String)content;
		Scanner scanner = new Scanner(results);
	    while ( scanner.hasNext() ){
	    Song song = parseString(scanner, results);
	    if(song != null)	
	    	songArray.add(song);

	    }
	    
	    
		return songArray;
	}
	
	public static Song parseString(Scanner scanner, String results) throws MalformedURLException, IOException {
		String name = null;
		String artist = null;
		String url = null;
		String songID = null;
		String picture = null;
	    String newLine = scanner.nextLine();
	    Song tempSong = new Song();
	    	newLine = newLine.trim();

	        if (newLine.equals("<track>")) {

	        	newLine = scanner.nextLine().trim();
		        name = newLine.substring(6,newLine.length()-7); //name
		    	newLine = scanner.nextLine().trim();
		    	artist = newLine.substring(8,newLine.length()-9); //Artist
		    	newLine = scanner.nextLine().trim();
		    	url = newLine.substring(5,newLine.length()-6); //url
		    	songID = getID(name, artist); // songID
		    	
		    	//go down to pictures
		    	newLine = scanner.nextLine().trim();
		    	newLine = scanner.nextLine().trim();
		    	newLine = scanner.nextLine().trim();
		    	newLine = scanner.nextLine().trim();
		    	newLine = newLine.replace(" ", "+");
		    	if (newLine.length() > 20){
		    	if (newLine.substring(0,21).equals("<image+size=\"medium\">")){
		    		picture = newLine.substring(21, newLine.length()-8);
		    		tempSong.setPicture(picture);
		    		
		    	}}
		    	tempSong.setSongID(songID);
		    	tempSong.setTitle(name);
		    	tempSong.setURL(url);
		    	tempSong.setArtist(artist);
		    	
		    	System.out.println(name +" "+ artist + " " + url + " " + songID);
		    	return tempSong;
	        }
	return null;
	
	}
	
	
	public static String getID(String track, String artist) throws MalformedURLException, IOException {
			String apiKey = "54a95dbf1f737c65aa382725431d8aab";
			String name = track;
			String art = artist;
			name = name.replaceAll(" ", "+");
			art = art.replaceAll(" ", "+");
			String songID = null;

			WebFiles file   = new WebFiles("http://ws.audioscrobbler.com/2.0/?method=track.getinfo&track=" + name + "&artist=" + art + "&api_key=" + apiKey);

			Object content = file.getContent( );
			String results = (String)content;
			Scanner scanner = new Scanner(results);
		    while ( scanner.hasNext() ){
		    String newLine = scanner.nextLine();
		    	newLine = newLine.trim();
		        if (newLine.equals("<track>")) {
		        	newLine = scanner.nextLine().trim();;
		        	songID = newLine.substring(4,newLine.length()-5); //name
		        	break;
		        }
		    }
		    
	return songID;
	}

}
