package ca.ubc.cpsc.mystuff.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MovieDBWebService {

	private static final String CONNECT_URL = "http://api.themoviedb.org/2.1/Movie.search/en/xml/7253e0115550221036e1a4a61facd12b/";
	private String searchURL = null;
	private ArrayList<Movie> movieList;
	
	public MovieDBWebService(String movieName){
		searchURL = CONNECT_URL + movieName.replace(' ', '+');
		movieList = new ArrayList<Movie>();
	}
	
	public ArrayList<Movie> getMovies() throws Exception {
		URL url = new URL(searchURL);
		InputStream input = url.openStream();
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document d = db.parse(input);
		NodeList list = d.getElementsByTagName("movie");
		String img;
		for(int i=0; i < list.getLength(); i++) {
			Element e = (Element) list.item(i);
			NodeList l1 = e.getElementsByTagName("name");
			NodeList l2 = e.getElementsByTagName("rating");
			NodeList l3 = e.getElementsByTagName("overview");
			NodeList l4 = e.getElementsByTagName("id");
			NodeList l5 = e.getElementsByTagName("images");
			Element im = (Element) l5.item(0);
			try{
				NodeList l6 = im.getElementsByTagName("image");
				Element one = (Element) l6.item(0);
				 img = one.getAttribute("url");
			}catch(NullPointerException e1){
				img = "";
			}
			
			String name = l1.item(0).getTextContent();
			int rating = (int) Double.parseDouble(l2.item(0).getTextContent());
			String overview = l3.item(0).getTextContent();
			int id = Integer.parseInt(l4.item(0).getTextContent());
			movieList.add(new Movie(name, rating, id, overview, img));
			System.out.println(name);
		}
		return movieList;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void checkResponse(InputStream input) throws Exception {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
		NodeList list = doc.getElementsByTagName("geoname");
		for(int i=0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			NodeList name = element.getElementsByTagName("name");
			System.out.print(name.item(0).getTextContent() + ": ");
			NodeList lat = element.getElementsByTagName("lat");
			NodeList lng = element.getElementsByTagName("lng");
			System.out.println("(" + lat.item(0).getTextContent() + ", " + lng.item(0).getTextContent() + ")");
		}
	}
}