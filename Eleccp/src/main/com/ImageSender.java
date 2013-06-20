package main.com;



import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageSender extends Activity {
	
	private static Uri imageuri;
	private static Bitmap imageone ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		
		ImageView tv =(ImageView)findViewById(R.id.imagept);
	final Button imageok = (Button)	findViewById(R.id.imageok);
	final Button imagecancel = (Button)	findViewById(R.id.imagecancel);
		Bitmap bitmapone;
		
		try {
			bitmapone = (Bitmap)MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageuri);
			imageone = bitmapone;
		  tv.setImageBitmap(bitmapone);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getBaseContext(), e.getMessage(), 10).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(getBaseContext(), e.getMessage(), 10).show();
		}
		
		
		
		
			imageok.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try{
				Profile.bitmap = ImageSender.imageone;
                	
                	Intent intr = new Intent("main.com.PROFILE");
                	startActivity(intr);
					}
					catch(Exception e)
					{
						
						
						Toast.makeText(getApplicationContext(),e.getMessage(), 10).show();
					}
				}
			});
			
			imagecancel.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					Intent intent = new Intent("main.com.CAMERAACTIVITY");
					startActivity(intent);
				}
			});
			
		}
		
		public void setImageUri(Uri imageone)
		{
			
			
			imageuri = imageone;
			
			
		}
}