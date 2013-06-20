package BusinessLogic.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;

import Network.ServerConnetor;

import main.com.EleccpActivity;

public class SearcherHandler {
	
	
	private String url;
	private String name;
	private int pid;
	private int age;
	
	
	public SearcherHandler(String name,String value)
	{
		
		final String server = EleccpActivity.server;
		if(name.equals("pid"))
		{
			this.pid = Integer.parseInt(value);
			
			this.url ="http://"+server+"/project/patientgetter.php";
			}
		if(name.equals("name"))
		{
			this.name = value;
			this.url ="http://"+server+"/project/namesgetter.php";
			
		}	
		
	
		
		
	}
	
	
	private int age(String birth)
	{
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
	String array[]= birth.split("/");
	int birthyear = Integer.parseInt(array[2]);
 this.age = year -birthyear;
		
		return age;
		
	}
	
	private HashMap calculate(int pid)// function for getdetails of patient from database
	{
		
		HashMap det = new HashMap();
		ServerConnetor  con = new ServerConnetor();
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 nameValuePairs.add(new BasicNameValuePair("pid",String.valueOf(this.pid)));
		String result = con.authenticate(nameValuePairs, this.url);
		
		try{
		     JSONArray   jArray = new JSONArray(result);
		        JSONObject json_data=null;
		        
		       
		        for(int i=0;i<jArray.length();i++){
		               json_data = jArray.getJSONObject(i);
		           
		              String dbname =json_data.getString("name");
		           String dbbirth =json_data.getString("birth");
		           String telephone =json_data.getString("telephone");
		           String address =json_data.getString("address");
		           String image =json_data.getString("image");
		              det.put("name", dbname);
		              det.put("birth", dbbirth);
		              det.put("telephone", telephone);
		              det.put("address",address);
		              det.put("image", image);
		           
		                
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
	
	private HashMap calculate(String name)// function for getdetails of patient from database
	{
		String passing =name.substring(0,1)+"%";
		HashMap det = new HashMap();
		ServerConnetor  con = new ServerConnetor();
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 nameValuePairs.add(new BasicNameValuePair("first",passing));
		String result = con.authenticate(nameValuePairs, this.url);
		
		try{
		     JSONArray   jArray = new JSONArray(result);
		        JSONObject json_data=null;
		        
		       
		        for(int i=0;i<jArray.length();i++){
		               json_data = jArray.getJSONObject(i);
		           System.out.println(i);
		              String dbname =json_data.getString("name");
		           String pid =json_data.getString("pid");
		           String telephone =json_data.getString("telephone");
		           StringBuffer bf = new StringBuffer();
		                  bf.append(dbname);
		                  bf.append(":");
		                  bf.append(pid);
		                  bf.append(":");
		                  bf.append(telephone);
		              det.put(pid, bf);
		              
		              
		           
		                
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
	
	
	
	
	
	
	
	
	
	
	
	
	private Bitmap createImage(String image)// image creation function
	{
		
		Bitmap bitmap=null;
		
		
	try {
		byte ar[]=	Base64.decode(image);
		
		
	 bitmap=BitmapFactory.decodeByteArray(ar,0,ar.length);
		

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	return bitmap;	
		
	}
	
	
	
	public HashMap details() // public interface for send details
	{
		HashMap map = new HashMap();
		HashMap returns;
		returns = calculate(pid);
	String name= (String) returns.get("name");
	String birth =(String) returns.get("birth");
	String image = (String) returns.get("image");
		int age =age(birth);
		Bitmap bitmap = createImage(image);
		map.put("name", name);
		map.put("age", age);
		map.put("image", bitmap);
		return map;
	}
	
	public HashMap detailsall() // public interface for send details
	{
		
		HashMap returns;
		returns = calculate(name);
	
		return returns;
	}
	
	
	

}
