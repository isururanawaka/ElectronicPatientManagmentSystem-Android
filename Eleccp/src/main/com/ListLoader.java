package main.com;

import java.util.ArrayList;
import java.util.HashMap;


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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListLoader extends Activity{
	
	
	
	 ListView mListData;
	 ArrayList<PatientInfo> patientSms;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.listloader);
		mListData = (ListView)findViewById(R.id.lvData);

        // receive list incoming messages

         patientSms = getIntent().getParcelableArrayListExtra("patientList");
        if(patientSms == null || patientSms.size()==0)
        {
           // if(listSms.size() ==0)
            //{
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
            	builder.setMessage("No Patients Found Are you sure you want to exit?")
            	       .setCancelable(false)
            	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            	           public void onClick(DialogInterface dialog, int id) {
            	              ListLoader.this.finish();
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

       if(patientSms != null && patientSms.size() > 0) {
           PatientInfoAdapter adapter = new PatientInfoAdapter(this, patientSms);
                     mListData.setAdapter(adapter);
         }
       
       
       mListData.setOnItemClickListener(new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			final int num = Integer.parseInt(patientSms.get(arg2).getPID());
			AlertDialog.Builder builder = new AlertDialog.Builder(ListLoader.this);
        	builder.setMessage("Name:"+patientSms.get(arg2).getname()+"\n"+"PID:"+patientSms.get(arg2).getPID()+"\n"+"Telephone:"+patientSms.get(arg2).getTelephone())
        	       .setCancelable(true)
        	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	           public void onClick(DialogInterface dialog, int id) {
        	        	   SearcherHandler sr = new SearcherHandler("pid", String.valueOf(num));
        		    		HashMap map = sr.details();
        		    		  
        		    		  String nameone =    (String)map.get("name");
        				      Integer age = (Integer)map.get("age");
        				      Bitmap image = (Bitmap)map.get("image");
        		    		  Detail dp = new Detail();
        		    		  dp.setLayout(nameone, age,image,num);
        		    		  Intent intent = new Intent("main.com.DETAIL");
        		    		  startActivity(intent);
        	           }
        	       });
        	       
        	AlertDialog alert = builder.create();
        	
        	alert.show();
			

			
		}
    	   
	});
      
	}

}
