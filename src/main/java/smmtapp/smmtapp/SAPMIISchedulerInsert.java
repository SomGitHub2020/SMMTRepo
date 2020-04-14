package smmtapp.smmtapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SAPMIISchedulerInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new SAPMIISchedulerInsert().insertMIISchData("9.220.9.130","50200","som","password@1","1", "2", "3", "4"));
	}

	//String returnMsg = msserverCon.insertMIISchData(ID,Name,FullName,Pattern);

	public String insertMIISchData(String IP, String Port,String User,String Pass, String SchID, String Name,String FullName,String Pattern) {

		String Status = null;

		try {

			//URL url = new URL("http://10.116.65.81:50200/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1");
			URL url = new URL("http://"+IP+":"+Port+"/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/SMMT/SQL_InsertMIISchJobDetails&Param.1="+SchID+""
					+ "&Param.2="+Name+"&Param.3="+FullName+"&Param.4="+Pattern+"&Content-Type=text/xml&IllumLoginName="+User+"&IllumLoginPassword="+Pass);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {
				Status = output;
				if(Status.indexOf("Command Query Successful") > 0) {
					return "Success";
				}else {
					return "Failed";
				}
				//System.out.print(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			Status = e.getMessage();

		} catch (IOException e) {

			Status = e.getMessage();
		}

		return Status;//Command Query Successful
	}	

}
