package main.com;



import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import BusinessLogic.com.ProfileHandler;
import BusinessLogic.com.SearcherHandler;
import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends Activity{
	
	
	public static Bitmap bitmap;
	public static Uri uri;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		setContentView(R.layout.profile);
		
		super.onCreate(savedInstanceState);
		
		final Button create=(Button)  findViewById(R.id.createp);// button for send data to database
		final DatePicker picker = (DatePicker)findViewById(R.id.datePicker1);// data picker
		final EditText name =(EditText) findViewById(R.id.namep);// get name
		final EditText address =(EditText)findViewById(R.id.address);// get address
		 final EditText phone =(EditText) findViewById(R.id.phone);// // get phone number
		
		
		
		
		
		// button for access camera application
		
		
		
		create.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			CharSequence pname = name.getText();// get name
			CharSequence paddress = address.getText();// get address
			CharSequence pphone =  phone.getText();// get phone number
			String ppname = pname.toString().trim();
			String ppadress = paddress.toString().trim();
			String ppphone = pphone.toString().trim();
			Bitmap bitmapone;
			if(uri != null)
			{
				
				
				/*try {
					Toast.makeText(getBaseContext(), String.valueOf(uri), 10).show();
					bitmapone = (Bitmap)MediaStore.Images.Media.getBitmap(Profile.this.getContentResolver(), uri);
					bitmap = bitmapone;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(getApplicationContext(), e.getMessage(), 10).show();
				}*/
			}
			
				
			
			
		    if(bitmap == null)
			{
			 bitmap	= BitmapFactory.decodeResource(getResources(),R.drawable.photo);

						
				
			}
			 
		        try{
				      
					ByteArrayOutputStream bao = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bao);
                    byte [] ba = bao.toByteArray();
                    String ba1=BusinessLogic.com.Base64.encodeBytes(ba);	
                    
                    int date = picker.getDayOfMonth();
                    int month = picker.getMonth();
                    int year = picker.getYear();
                    
                    String pbirth=String.valueOf(date)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
				
				ProfileHandler pm = new ProfileHandler(ppname, pbirth, ppphone, ppadress,ba1);
				
				String pid = pm.save();// save 
				
				Toast.makeText(getApplicationContext(), "PID of patient is "+pid, 10).show();
				
				SearcherHandler sr = new SearcherHandler("pid", pid);
	    		 HashMap map = sr.details();
	    		  
	    		  String nameone =    (String)map.get("name");
			      Integer age = (Integer)map.get("age");
			    Bitmap image = (Bitmap)map.get("image");
	    		     Detail dp = new Detail();
	    		       dp.setLayout(nameone, age,image,Integer.parseInt(pid));
	    		   
	    		      Intent intent = new Intent("main.com.DETAIL");
	    		       startActivity(intent);
 		      
 				
		        } catch(Exception e)
		        {
		        	
		        	Toast.makeText(getApplicationContext(), e.getMessage(), 10).show();
		        }
 		      
				
			}
		});
		
		
		
	
		
	}
	
	
	
}
