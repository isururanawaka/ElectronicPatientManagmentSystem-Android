package BusinessLogic.com;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;

import Network.ServerConnetor;

import main.com.EleccpActivity;

public class ProfileHandler {
	
	private String name;
	private String birthday;
	private String telephone;
	private String address;
	private String image;
	private String pid;
	private String url;
	private ArrayList<NameValuePair> nameValuePairs;
	
	public ProfileHandler(String name,String birthday,String telephone,String address,String image)
	{
		this.name = name;
		this.birthday = birthday;
		this.telephone= telephone;
		this.address= address;
		this.image= image;
		String server = EleccpActivity.server;
		this.url ="http://"+server+"/project/patientsaver.php";
		this.nameValuePairs = new ArrayList<NameValuePair>();
	}
	
	
	public String save() // send values to server connector object to save in database.
	{
		
		nameValuePairs.add(new BasicNameValuePair("name", name));
		nameValuePairs.add(new BasicNameValuePair("birthday", birthday));
		nameValuePairs.add(new BasicNameValuePair("image", image));
		nameValuePairs.add(new BasicNameValuePair("address", address));
		nameValuePairs.add(new BasicNameValuePair("telephone", telephone));
		ServerConnetor  con = new ServerConnetor();
		String result = con.authenticate(nameValuePairs, this.url);
		String pid = getPID(result);
		
		
		
		return pid;
		
		
	}
	
	private String getPID(String result)// fucntion for retrive pid
	{
		
		try{
		     JSONArray   jArray = new JSONArray(result);
		        JSONObject json_data=null;
		        
		       
		        for(int i=0;i<jArray.length();i++){
		               json_data = jArray.getJSONObject(i);
		           
		             this.pid =String.valueOf(json_data.getInt("pid"));
		           
		             
		           
		                
		           }
		        }
		        catch(JSONException e1){
		        	e1.printStackTrace();
		      	
		        } catch (ParseException e1) {
		  			e1.printStackTrace();
		  	}
		return pid;
		
	}
	
	
	
	
	

}
