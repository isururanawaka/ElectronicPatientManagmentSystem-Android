package BusinessLogic.com;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Network.ServerConnetor;
import android.net.ParseException;

import main.com.EleccpActivity;

public class ManagerHandler {
	
	
	private String url;
	
	public ManagerHandler()
	{
		final String server = EleccpActivity.server;
		this.url ="http://"+server+"/project/managerhandler.php";
	}
	
	
	
	private ArrayList<StringBuffer> calculate()
	{
		

		ArrayList<StringBuffer> det = new ArrayList<StringBuffer>();
		ServerConnetor  con = new ServerConnetor();
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 String result = con.authenticate(nameValuePairs, this.url);
		
		try{
		     JSONArray   jArray = new JSONArray(result);
		        JSONObject json_data=null;
		        
		       
		        for(int i=0;i<jArray.length();i++){
		               json_data = jArray.getJSONObject(i);
		           
		               String name =json_data.getString("username");
			           String telephone =json_data.getString("telephone");
			           
			           StringBuffer bf = new StringBuffer();
			                  bf.append(name);
			                  bf.append(":");
			                  bf.append(telephone);
			                  
			              det.add(bf);
		                
		           }
		        }
		        catch(JSONException e1){
		        	e1.printStackTrace();
		      	 // Toast.makeText(getBaseContext(), "No City Found" ,Toast.LENGTH_LONG).show();
		        } catch (ParseException e1) {
		  			e1.printStackTrace();
		  	}

		
		return det;
		
		
		
		
		
		
		
	}
	public ArrayList<StringBuffer> getname()// public interface for send details
	{
		
		ArrayList<StringBuffer> returns;
		returns = calculate();
	
		return returns;
	}
	

}
