package main.com;


import java.util.ArrayList;
import java.util.HashMap;

import BusinessLogic.com.DoctorInfo;
import BusinessLogic.com.LoginHandler;
import BusinessLogic.com.ManagerHandler;
import BusinessLogic.com.PatientInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	
	public static int privillage=5;
	public static String doctorname;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	
		final Button button =(Button)findViewById(R.id.login123);// button for login detilas handle
	button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
    	  
    	  
          EditText username = (EditText)findViewById(R.id.user); // enterd username
           EditText password =(EditText)findViewById(R.id.pass);// enterd password
     	   
     	CharSequence user = username.getText();
     	 CharSequence pass = password.getText();
     	 LoginHandler log = new LoginHandler(user.toString().trim(), pass.toString().trim());// string converstion
     	 if(log.Validate())
     	 {
     		if(log.getPrivillage()==1)
     		{
     			privillage=1;
     			Toast.makeText(getApplicationContext(), "Welcome Dr "+user, 7).show();// doctor
     			doctorname = user.toString();
     			Intent intent = new Intent("main.com.ACTION");
         		startActivity(intent);
     			
     		}
     		if(log.getPrivillage()==0)
     		{
     			privillage=0;
     			Toast.makeText(getApplicationContext(), "Welcome  "+user, 7).show();// nurse
     			Intent intent = new Intent("main.com.ACTION");
         		startActivity(intent);
     			}
     		if(log.getPrivillage()==2)
     		{
     			privillage=2;
     			Toast.makeText(getApplicationContext(), "Welcome Manager "+user, 7).show();
     			Intent intent = new Intent("main.com.MANAGERACCESS");
         		startActivity(intent);
     		 
     	 }
     	 else{
     	Toast.makeText(getApplicationContext(), "username or Password incorrect", 5).show();
     	 }
      }
    
		
		
		
      }});

	}}
