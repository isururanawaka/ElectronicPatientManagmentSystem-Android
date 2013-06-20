package BusinessLogic.com;

import java.util.ArrayList;

import main.com.EleccpActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;

import Network.ServerConnetor;

public class NoteHandler {
	private boolean noteadded;
	private String note;
	private String pid;
	private String doctor;
	private String date;
	private String addURL;
	private String getURL;
	
	
	
	public NoteHandler(String note,String pid,String doctor,String date)
	{
		noteadded = false;
	 this.note = note;
	 this.pid = pid;
	 this.doctor = doctor;
	 this.date =date;
	String  server = EleccpActivity.server;
	 this.addURL = "http://"+server+"/project/notesadd.php";
		}
	
	public  NoteHandler(String pid)
	{
		this.pid = pid;
		
		String  server = EleccpActivity.server;
		 this.addURL = "http://"+server+"/project/getnotes.php";
		
	}
	
	
	
	public boolean addNote() // send doctors note to the server connector class
	{
		
		  ServerConnetor  con = new ServerConnetor();
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 nameValuePairs.add(new BasicNameValuePair("pid",this.pid));
		 nameValuePairs.add(new BasicNameValuePair("date",this.date));
		 nameValuePairs.add(new BasicNameValuePair("note",this.note));
		 nameValuePairs.add(new BasicNameValuePair("doctor",this.doctor));
		 String result = con.authenticate(nameValuePairs, this.addURL);
		
		if(result != null)
		{
			noteadded =true;
		}
		else if(result == null)
		{
		noteadded= false;
		}
	return noteadded;
	
	}
	
	public StringBuffer getNotes() // code which retrive note when sending pid
	{
	 StringBuffer bf = new StringBuffer();
		
	 ServerConnetor  con = new ServerConnetor();
	 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	 nameValuePairs.add(new BasicNameValuePair("pid",this.pid));
	 String result = con.authenticate(nameValuePairs, this.addURL);
		
	bf = process(result);
	 
	 
	 
	 
	 
		return bf;
		
	}
	
	private StringBuffer process(String result) // notes retriver from Json object  
	{
		StringBuffer sb = new StringBuffer();
		try{
		     JSONArray   jArray = new JSONArray(result);
		        JSONObject json_data=null;
		        
		       
		        for(int i=0;i<jArray.length();i++){
		               json_data = jArray.getJSONObject(i);
		           
		           int ppid =json_data.getInt("pid");
		           String date =json_data.getString("date");
		           String note =json_data.getString("note");
		           String doctor =json_data.getString("doctor");
		           
		              sb.append(date);
		              sb.append("--");
		              sb.append("DR.");
		              sb.append(doctor);
		              sb.append("\n");
		              sb.append(note);
		              sb.append("\n\n\n");
		           
		                
		           }
		        }
		        catch(JSONException e1){
		        	e1.printStackTrace();
		      	 
		        } catch (ParseException e1) {
		  			e1.printStackTrace();
		  	}

		
		
		
		return sb;
		
		
	}
	

}
