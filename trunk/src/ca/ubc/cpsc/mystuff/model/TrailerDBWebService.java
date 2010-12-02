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

public class TrailerDBWebService {
	private static final String SEARCH_URL_PREFIX = "http://api.traileraddict.com/?film=";

	public TrailerDBWebService(){
	}

	public static String getTrailerByMovieName(String movieName) { 
		try {
			URL url = new URL(SEARCH_URL_PREFIX+movieName.replace(" ", "-"));
			InputStream input = url.openStream();
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document d = db.parse(input);
			NodeList list = d.getElementsByTagName("trailer");
			Element e = (Element) list.item(0);
			NodeList l1 = e.getElementsByTagName("embed");
			return l1.item(0).getTextContent();
		} catch (Exception e) {
			return "";
		}
	}

}