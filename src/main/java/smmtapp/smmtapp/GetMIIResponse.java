package smmtapp.smmtapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetMIIResponse {
	
	//public String stringURL = null;
	
	public String executeGETService(String stringURL) throws IOException{
		String output, outValue = null;
		
			URL url = new URL(stringURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			InputStream in = conn.getInputStream();
			
	        DocumentBuilderFactory dbf =
	            DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = null;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Document doc = null;
			try {
				doc = (Document) db.parse(in);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");
			//NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("TimeZoneResponse");
	        
	        // iterate the employees
			/*
	        for (int i = 0; i < nodes.getLength(); i++) {
	           Element element = (Element) nodes.item(i);
	           
	           NodeList id = element.getElementsByTagName("ID");
	           Element line = (Element) id.item(0);
	           String ID = getCharacterDataFromElement(line);

	           NodeList name = element.getElementsByTagName("Name");
	           line = (Element) name.item(0);
	           String Name = getCharacterDataFromElement(line);
	           
	           NodeList blspath = element.getElementsByTagName("FullName");
	           line = (Element) blspath.item(0);
	           String FullName = getCharacterDataFromElement(line);
	           
	           NodeList pattern = element.getElementsByTagName("Pattern");
	           line = (Element) pattern.item(0);
	           String Pattern = getCharacterDataFromElement(line);
	           
		      
		       //String returnMsg = msserverCon.insertMIISchData(ID,Name,FullName,Pattern);
		      
		       outValue = outValue + returnMsg;
		       System.out.println("Data is inserted "+returnMsg);
	        }
	        */
			
			 MSSQLConnection msserverCon = new MSSQLConnection();
		      
		     String outValue1 = msserverCon.dbConn("som_sa","password@12345");
	        return outValue1;
	}


	 public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		       CharacterData cd = (CharacterData) child;

		       return cd.getData();
		    }
		    return "?";
		  }
	}
