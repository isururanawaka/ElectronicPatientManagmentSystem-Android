package main.com;




import java.util.ArrayList;


import BusinessLogic.com.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EleccpActivity extends Activity {
    /** Called when the activity is first created. */
	
	public static String server;
	private ListView mListData;
	private  ArrayList<SmsInfo> listSms;
	private static int count=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.main)  ;    
       
       
    final    AlertDialog.Builder builder = new AlertDialog.Builder(this);
       
       final Button button = (Button) findViewById(R.id.connect);
       button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
        	   ProgressDialog dialog = ProgressDialog.show(EleccpActivity.this, "", 
                       "ServerFinding. Please wait...", true);
 				dialog.setCanceledOnTouchOutside(true);
 				dialog.show();
        	   
 				
 				
 				 listSms = getIntent().getParcelableArrayListExtra("ListSMS");
 		        if(listSms == null)
 		        {
 		          
 		            	
 		            	
 		            	builder.setMessage("No Sever Found Are you sure you want to exit?")
 		            	       .setCancelable(false)
 		            	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
 		            	           public void onClick(DialogInterface dialog, int id) {
 		            	              EleccpActivity.this.finish();
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

 		       if(listSms != null && listSms.size() > 0) {
 		    	   boolean found = false;
 		    	  for(int k =0;k<listSms.size();k++)
 		    	  {
 		    		 String serverone = listSms.get(k).getContent();
 		    		 System.out.print(serverone);
 		    		   if(serverone.contains("server"))
 		    		   {
 		    			 server = (serverone.substring(serverone.indexOf(":")+1)).trim();
 		    			   found= true;
 		    			   count = 1;
 		    			   break;
 		    		   }
 		    		  
 		    		  
 		    		  
 		    		  
 		    	  }
 		    	   
 		    	  if(found && count ==1)
 		    	  {
 		    	 Toast.makeText(getApplicationContext(), server, 5).show(); 
		    	  builder.setMessage("Sever Found Are you sure you want to connect?")
       	       .setCancelable(false)
       	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
       	           public void onClick(DialogInterface dialog, int id) {
       	        	   
       	        	   
       	        	   
       	        	   
       	        	   
       	        	   Intent login = new Intent("main.com.LOGIN");// main login page
       	          		 startActivity(login);
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
 		       
 		       
 		       
 		      
 				
 		       }
 				
 				
 				
 				
 				
 				
 				
 				
 				
           	  
        	  
        	   
           }
       });

  
    }
   
    
    
}