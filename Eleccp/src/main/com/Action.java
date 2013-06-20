package main.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Action extends Activity{

	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.action);
		
	final Button exsisting =	(Button)findViewById(R.id.existingprofile);// button for get exisitng profile
	 exsisting.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
    	  
    	  Intent intentone = new Intent("main.com.SEARCH");
    	  startActivity(intentone);
    	  
    	  
    	  
      }
	   });
      
	 final Button newprofile =	(Button)findViewById(R.id.newprofile);// buttton for get new profile
	newprofile.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
    	  
    	  Intent intenttwo = new Intent("main.com.PHOTO");
    	  startActivity(intenttwo);
    	  
    	  
    	  
      }
	   });
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   }
      }
		
		
		
	

