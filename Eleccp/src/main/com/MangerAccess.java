package main.com;

import java.util.ArrayList;
import java.util.HashMap;

import BusinessLogic.com.DoctorInfo;
import BusinessLogic.com.ManagerHandler;
import BusinessLogic.com.PatientInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MangerAccess extends Activity{
	
	
	static ArrayList<DoctorInfo> doctorlist = new ArrayList<DoctorInfo>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.access);
		final  Button butta = (Button)findViewById(R.id.sendtodoc);
		
		
		
		 butta.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			ManagerHandler mr = new ManagerHandler();	
				
ArrayList<StringBuffer> mp = mr.getname();
System.out.println(mp.size());
//Toast.makeText(getApplicationContext(), mp.size(), 4).show();
//String[] array = {"janiya","12345"};
//doctorlist.add(new DoctorInfo(array[0], array[1]));
	    		for(int k=0;k< mp.size();k++)
	    		{
	    			
	    			StringBuffer bf = (StringBuffer)mp.get(k);
	    			if(bf != null)
	    			{
	    				
	    			String det  = bf.toString();
	    			String[] array = det.split(":");
	    		//String[] array = {"janiya","12345"};
	    			   if(array != null)
	    			   {
	    				   doctorlist.add(new DoctorInfo(array[0], array[1]));
	    				   
	    				   
	    				   
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
	    		
	    		if(doctorlist.size() >0) {

	                // notify new arriving message

	               
	                // set data to send

	                Intent data = new Intent(getApplicationContext(),ManagerProfile.class);

	                // new activity

	                data.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

	 System.out.print("okokokoko");

	                data.putParcelableArrayListExtra("doctorList", doctorlist);
	                // start

	                getApplicationContext().startActivity(data);

	            }

	    		
	    		
	    		
	    		
	    		
	    		
	    		
				
			}
		});
	}

}
