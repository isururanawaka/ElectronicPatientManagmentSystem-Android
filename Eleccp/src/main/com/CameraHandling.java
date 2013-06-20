package main.com;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

public class CameraHandling extends Activity {
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static Uri fileUri;
	public static final int MEDIA_TYPE_IMAGE = 1;


	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.profile);
	        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

	        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
	    
	    		  
	       
	        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

	        // start the image capture Intent
	        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

	    }
	
	 private static Uri getOutputMediaFileUri(int type){
	        return Uri.fromFile(getOutputMediaFile(type));
	  }
	
	 private static File getOutputMediaFile(int type){
	        // To be safe, you should check that the SDCard is mounted
	        // using Environment.getExternalStorageState() before doing this.

	        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	                  Environment.DIRECTORY_PICTURES), "MyCameratesting");
	        // This location works best if you want the created images to be shared
	        // between applications and persist after your app has been uninstalled.

	        // Create the storage directory if it does not exist
	        if (! mediaStorageDir.exists()){
	            if (! mediaStorageDir.mkdirs()){
	                Log.d("MyCameraApp", "failed to create directory");
	                return null;
	            }
	        }

	        // Create a media file name
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        File mediaFile;
	        if (type == MEDIA_TYPE_IMAGE){
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "IMG_"+ timeStamp + ".jpg");
	       
	        } else {
	            return null;
	        }

	        return mediaFile;
	    }

	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	            if (resultCode == RESULT_OK) {
	                // Image captured and saved to fileUri specified in the Intent
	                Toast.makeText(this, "Image saved ", 7).show();
	                
	               
	                try {
	                	
	                ImageSender prof = new ImageSender();
	                	prof.setImageUri(fileUri);
	                	Intent intr = new Intent("main.com.IMAGESENDER");
	                	startActivity(intr);
	                	
						
					} catch (Exception e) {
						
						Toast.makeText(this, e.getMessage() , Toast.LENGTH_LONG).show();
					}
	                
	            } else if (resultCode == RESULT_CANCELED) {
	            	Toast.makeText(this,"User Canceled" , Toast.LENGTH_LONG).show();
	            } else {
	            	Toast.makeText(this,"Image Capture Failed" , Toast.LENGTH_LONG).show();
	            }
	        }
	    }
	 
	 
}
