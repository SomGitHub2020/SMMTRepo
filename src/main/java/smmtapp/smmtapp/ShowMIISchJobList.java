package smmtapp.smmtapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ShowMIISchJobList {

	public String displayMIISchJobs(List<MIISchJob> listMIISchJobs1) throws IOException{
		String result="";
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://smmtconn:3306/smmtdb?user=root&password=IwfGUwTxbE1jwvVa&useSSL=false");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `MIISchedulerJobs`");  
			while(rs.next()){  
				String ID = rs.getString(1);
				String Name = rs.getString(2);
				String FullName = rs.getString(3);
				String Pattern = rs.getString(4).replaceAll(" ", "");
			
				
				listMIISchJobs1.add(new MIISchJob(ID,Name,FullName,Pattern));
			}
			result = "SUCCESS";
			con.close();
			//return result;
		}
		catch(Exception e){
			e.printStackTrace();
			result = "ERROR";
		}
		//System.out.println(e);
		return result;

	}
}
