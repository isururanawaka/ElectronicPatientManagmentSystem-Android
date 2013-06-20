package main.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Photo extends Activity{

	@Override
	public  void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.photo);
		
	final Button but = (Button)	findViewById(R.id.photobut);
	
	  but.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent("main.com.CAMERAACTIVITY");
			startActivity(intent);
		}
	});
	}
}
