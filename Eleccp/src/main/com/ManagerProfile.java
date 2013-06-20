package main.com;

import java.util.ArrayList;
import java.util.HashMap;

import BusinessLogic.com.DoctorInfo;
import BusinessLogic.com.DoctorInfoAdapter;
import BusinessLogic.com.PatientInfo;
import BusinessLogic.com.PatientInfoAdapter;
import BusinessLogic.com.SearcherHandler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ManagerProfile extends Activity {
	ListView mListData;
		 ArrayList<DoctorInfo> doctorSms;
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.doctorloader);
			mListData = (ListView)findViewById(R.id.doctorview);

	        // receive list incoming messages

	         doctorSms = getIntent().getParcelableArrayListExtra("doctorList");
	        if(doctorSms == null || doctorSms.size()==0)
	        {
	           // if(listSms.size() ==0)
	            //{
	            	
	            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	            	builder.setMessage("No Doctors Found Are you sure you want to exit?")
	            	       .setCancelable(false)
	            	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	            	           public void onClick(DialogInterface dialog, int id) {
	            	           ManagerProfile.this.finish();
	            	           }
	            	       })
	            	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
	            	           public void onClick(DialogInterface dialog, int id) {
	            	                dialog.cancel();
	            	           }
	            	       });
	            	AlertDialog alert = builder.create();
	            	
	            	alert.show();
	            	
	            	
	            	
	            	
	            }
	        
	       // }
	        // check condition

	       if(doctorSms != null && doctorSms.size() > 0) {
	           DoctorInfoAdapter adapter = new DoctorInfoAdapter(this, doctorSms);
	         
	           mListData.setAdapter(adapter);
	         }
	       
	       
	       mListData.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				final String num = doctorSms.get(arg2).getNumber();
				AlertDialog.Builder builder = new AlertDialog.Builder(ManagerProfile.this);
	        	builder.setMessage("Name:"+doctorSms.get(arg2).getContent()+"\n"+"NO:"+doctorSms.get(arg2).getNumber())
	        	       .setCancelable(true)
	        	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        	           public void onClick(DialogInterface dialog, int id) {
	        	        	   
	        	        	   MessageSender mc = new MessageSender();
	        	        	     mc.setPhone(num);
	        	          Intent intent = new Intent("main.com.SENDER");
	        	          startActivity(intent);
	        	           
	        	           
	        	           
	        	           
	        	           
	        	           
	        	           
	        	           
	        	           }
	        	       });
	        	       
	        	AlertDialog alert = builder.create();
	        	
	        	alert.show();
				

				
			}
	    	   
		});
	      
		}
}
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	


