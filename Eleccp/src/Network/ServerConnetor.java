package Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class ServerConnetor {
	
	
	private String url;
	private ArrayList<NameValuePair> nameValuePairs;
	private InputStream is=null;
	
	public   String authenticate(ArrayList<NameValuePair> nameValuePairs,String url)
	{
		String result= null;
		this.url=url;
		this.nameValuePairs =nameValuePairs;
		
		try{
	           HttpClient httpclient = new DefaultHttpClient();
	          
	           HttpPost httppost = new HttpPost(this.url);
	           
	           httppost.setEntity(new UrlEncodedFormEntity(this.nameValuePairs));
	           HttpResponse response = httpclient.execute(httppost);
	           HttpEntity entity = response.getEntity();
	           is = entity.getContent();
	           }catch(Exception e){
	        	  
	               Log.e("log_tag", "Error in http connection"+e.toString());
	          }
		
		try{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	       StringBuilder  sb = new StringBuilder();
	         sb.append(reader.readLine() + "\n");

	         String line="0";
	         while ((line = reader.readLine()) != null) {
	                        sb.append(line + "\n");
	          }
	          is.close();
	       result=sb.toString();
	          }catch(Exception e){
	        	  
	                Log.e("log_tag", "Error converting result "+e.toString());
	          }
		
		
		
		
		return result;
		
		
		
		
		
	}
	

}
