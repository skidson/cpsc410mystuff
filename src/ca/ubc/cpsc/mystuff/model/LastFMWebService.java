package ca.ubc.cpsc.mystuff.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

import ca.ubc.cpsc.mystuff.model.WebFiles;

public class LastFMWebService {


	
	public static ArrayList<Song> getSongs(String track, String lim, String art) throws MalformedURLException, IOException {

		ArrayList<Song> songArray = new ArrayList<Song>();
		
		String apiKey = "54a95dbf1f737c65aa382725431d8aab";
		//String appSecret = "4ef85cb5b8646ae31e7dfa7c74c5b3ee";
		
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
		songArray.add(parseString(scanner, results));

	    }
	    
	    
		return songArray;
	}
	
	public static Song parseString(Scanner scanner, String results) throws MalformedURLException, IOException {
		String name;
		String artist;
		String url;
		String medPicture;
		String songID;
	    String newLine = scanner.nextLine();
	    Song tempSong = new Song("urmom", "urothermom", 111, 111, 101, "urmomfriendsmom", "urmomsmom");
	    	newLine = newLine.trim();

	        if (newLine.equals("<track>")) {

	        	newLine = scanner.nextLine().trim();

		        name = newLine.substring(6,newLine.length()-7); //name
		    	newLine = scanner.nextLine().trim();

		    	artist = newLine.substring(8,newLine.length()-9); //Artist
		    	newLine = scanner.nextLine().trim();
		    	
		    	url = newLine.substring(5,newLine.length()-6); //url
		    	
		    	songID = getID(name, artist); // songID
		    	
		    	tempSong.setSongID(songID);
		    	tempSong.setTitle(name);
		    	tempSong.setURL(url);
		    	tempSong.setArtist(artist);
		    	//System.out.println(name +" "+ artist + " " + url + " " + songID);
	        
	        }
	return tempSong;
	
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
