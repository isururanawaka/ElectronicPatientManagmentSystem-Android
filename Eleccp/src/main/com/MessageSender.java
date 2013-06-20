package main.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageSender extends Activity{
	
	private static String phone;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.managermsg);
		
		  final  EditText tv = (EditText) findViewById(R.id.patientnum);
		  final EditText tvone= (EditText) findViewById(R.id.addinfo);
		  final Button buttr = (Button) findViewById(R.id.sending);
		
		  buttr.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				StringBuffer bf = new StringBuffer();
				  bf.append("You have "+tv.getText().toString()+"today");
				  bf.append("\n");
				  bf.append(tvone.getText().toString());
				  String message = bf.toString();
				
				
				if(phone != null)
				{
					
					sendSMS(phone,message);
					Toast.makeText(getApplicationContext(),"Message sent succesfully", 10).show();
					AlertDialog.Builder builder =new AlertDialog.Builder(MessageSender.this); 
					builder.setMessage("Do you want to exit")
		       	       .setCancelable(false)
		       	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		       	           public void onClick(DialogInterface dialog, int id) {
		       	        	  MessageSender.this.finish(); 
		       	        	   
		       	        	   
		       	        	   
		       	        	   
		       	        	   
		       	           }
		       	       })
		       	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
		       	           public void onClick(DialogInterface dialog, int id) {
		       	               Intent intr = new Intent("main.com.MANAGERACCESS");
		       	               startActivity(intr);
		       	        	   
		       	        	   
		       	           }
		       	       });
		       	AlertDialog alert = builder.create();
		       	
		       	alert.show();
					
				}
				
				else
				{
					
					Toast.makeText(getApplicationContext(),"cannot send", 10).show();
					
					
				}
				
				
				
				
			}
		});
		  
		  
		
		
	}
	
	
	private void sendSMS(String phoneNumber, String message)
    {        
    	String SENT = "SMS_SENT";
    	String DELIVERED = "SMS_DELIVERED";
    	
        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
            new Intent(SENT), 0);
        
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
            new Intent(DELIVERED), 0);
    	
        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode())
				{
				    case Activity.RESULT_OK:
					    Toast.makeText(getBaseContext(), "SMS sent", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					    Toast.makeText(getBaseContext(), "Generic failure", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				    case SmsManager.RESULT_ERROR_NO_SERVICE:
					    Toast.makeText(getBaseContext(), "No service", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				    case SmsManager.RESULT_ERROR_NULL_PDU:
					    Toast.makeText(getBaseContext(), "Null PDU", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				    case SmsManager.RESULT_ERROR_RADIO_OFF:
					    Toast.makeText(getBaseContext(), "Radio off", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				}
			}
        }, new IntentFilter(SENT));
        
        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode())
				{
				    case Activity.RESULT_OK:
					    Toast.makeText(getBaseContext(), "SMS delivered", 
					    		Toast.LENGTH_SHORT).show();
					    break;
				    case Activity.RESULT_CANCELED:
					    Toast.makeText(getBaseContext(), "SMS not delivered", 
					    		Toast.LENGTH_SHORT).show();
					    break;					    
				}
			}

			
        }, new IntentFilter(DELIVERED));        
    	
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);               
    }   
	
	
	public void setPhone(String phone)
	{
		
		this.phone = phone;
		
	}
	
	

}
