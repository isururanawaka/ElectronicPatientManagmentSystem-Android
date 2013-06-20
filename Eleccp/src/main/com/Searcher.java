package main.com;

import java.util.ArrayList;
import java.util.HashMap;

import BusinessLogic.com.PatientInfo;
import BusinessLogic.com.SearcherHandler;
import BusinessLogic.com.SmsInfo;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Searcher extends Activity {

	
	
	static ArrayList<PatientInfo> patientlist = new ArrayList<PatientInfo>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searcher);
		
		final Button newprofile =	(Button)findViewById(R.id.search);
		
		newprofile.setOnClickListener(new View.OnClickListener() {
	      public void onClick(View v) {
	    	  
	    	EditText edname =  (EditText)findViewById(R.id.names);
	    	EditText pid = (EditText)findViewById(R.id.pid);
	    	
	    	CharSequence name = edname.getText();
	    	CharSequence pids = pid.getText();
	    	if(pids.toString().trim().length() == 0 && name.toString().trim().length() ==0)
	    	{
	    		Toast.makeText(getApplicationContext(),"fill one Of pid or name", 10).show();
	    		
	    		
	    	}
	    	if(pids.toString().trim().length()>0)
	    	{
	    		String ppid = pids.toString().trim();
	    		SearcherHandler sr = new SearcherHandler("pid", ppid);
	    		HashMap map = sr.details();
	    		  
	    		  String nameone =    (String)map.get("name");
			      Integer age = (Integer)map.get("age");
			      Bitmap image = (Bitmap)map.get("image");
	    		  Detail dp = new Detail();
	    		  dp.setLayout(nameone, age,image,Integer.parseInt(ppid));
	    		  Intent intent = new Intent("main.com.DETAIL");
	    		  startActivity(intent);
	    		          
	    		  
	    		  
	    		
	    	}
	    	
	    	else if(name.toString().trim().length()>0)
	    	{
	    		String pname = name.toString().trim();
	    		SearcherHandler sr = new SearcherHandler("name", pname);
	    		HashMap mp = sr.detailsall();
	    		
	    		for(Object t:mp.keySet())
	    		{
	    			Toast.makeText(getApplicationContext(),((StringBuffer)mp.get(t)).toString(), 10).show();
	    			StringBuffer bf = (StringBuffer)mp.get(t);
	    			if(bf != null)
	    			{
	    			String det  = bf.toString();
	    			String[] array = det.split(":");
	    			
	    			   if(array != null)
	    			   {
	    				   patientlist.add(new PatientInfo(array[0], array[1], array[2]));
	    				   
	    				   
	    				   
	    			   }
	    			   else
		    			{
		    				
		    				Toast.makeText(getApplicationContext(),"No such name found", 10).show();
		    				
		    			}
		    			
	    			
	    			}
	    			else
	    			{
	    				
	    				Toast.makeText(getApplicationContext(),"No such name found", 10).show();
	    				
	    			}
	    			
	    			
	    		}
	    		
	    		if(patientlist.size() >0) {

	                // notify new arriving message

	               
	                // set data to send
                                         
	                Intent data = new Intent(getApplicationContext(),ListLoader.class);

	                // new activity

	                data.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

	 

	                data.putParcelableArrayListExtra("patientList", patientlist);
	                // start

	                getApplicationContext().startActivity(data);

	            }

	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	}
	    	  
	      }
		   });

		
		
		
		
	}
}
