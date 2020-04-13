package smmtapp.smmtapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetMIIResponse {
	 public String executeGETService(){
         String output, outValue = null;
         try {

            URL url = new URL("http://9.220.9.130:50200/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1");
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             //conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                     (conn.getInputStream())));

            

            while ((output = br.readLine()) != null) {
                 outValue = output;
                 System.out.print(output);
             }
             conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
         }
         return outValue;
     }
}
