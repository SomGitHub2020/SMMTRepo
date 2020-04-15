package smmtapp.smmtapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DisplayMIISchJob {
	
	
	public void displayMIISchJob(List<MIISchJob> listMIISchJobs2) throws IOException{
	

	  String stringURL = "http://9.220.9.130:50200/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/SMMT/SQL_GetMIISchJobList&Content-Type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1";
	  
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
		
      for (int i = 0; i < nodes.getLength(); i++) {
         Element element = (Element) nodes.item(i);
         
         NodeList id = element.getElementsByTagName("Sch_ID");
         Element line = (Element) id.item(0);
         String ID = getCharacterDataFromElement(line);

         NodeList name = element.getElementsByTagName("Name");
         line = (Element) name.item(0);
         String Name = getCharacterDataFromElement(line);
         
         NodeList blspath = element.getElementsByTagName("BLS");
         line = (Element) blspath.item(0);
         String FullName = getCharacterDataFromElement(line);
         
         NodeList pattern = element.getElementsByTagName("Pattern");
         line = (Element) pattern.item(0);
         String Pattern = getCharacterDataFromElement(line).replaceAll(" ", "");
         
         //MSSQLConnection msserverCon = new MSSQLConnection();
		   //String outValue1 = msserverCon.dbConn("som_sa","password@12345");
         //String returnMsg = msserverCon.insertMIISchData(ID,Name,FullName,Pattern);
         
               
         listMIISchJobs2.add(new MIISchJob(ID,Name,FullName,Pattern));
			
			System.out.print(i);

      }
      
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
