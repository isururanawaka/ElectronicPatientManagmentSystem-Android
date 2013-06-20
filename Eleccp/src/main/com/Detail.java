package main.com;

import java.util.Calendar;
import java.util.GregorianCalendar;

import BusinessLogic.com.NoteHandler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends Activity{
	
	private static String name;
	private static int age;
	private static Bitmap bitmap;
	private static int pid;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		final Button button = (Button)findViewById(R.id.viewd);// button for view notes
		final Button buttontwo =(Button)findViewById(R.id.addd);// but for add notes
		final TextView  tv = (TextView)findViewById(R.id.named2);
		final TextView  tvone =(TextView)findViewById(R.id.aged);
		final   ImageView im = (ImageView)findViewById(R.id.imageView1);// imgae container of patient
		final TextView tvtwo = new TextView(this);
		
		
		if(Login.privillage==0)
		{
			buttontwo.setEnabled(false);
			
			
		}
		
		tv.setText(name);
		tvone.setText(String.valueOf(age));
		im.setImageBitmap(bitmap);
		
		buttontwo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				Intent intent = new Intent("main.com.NOTEADD");
				startActivity(intent);
				
				NoteAdd nd = new NoteAdd();
				Calendar cal = new GregorianCalendar();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DATE);
			String	date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
				  nd.setdet(String.valueOf(pid), date, Login.doctorname);
				
				
				
				
				
				
			}
		});
		
		
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				NoteHandler nt = new NoteHandler(String.valueOf(Detail.pid));
				StringBuffer bf = nt.getNotes();
				NoteViewer br = new NoteViewer();
				  br.setNotes(bf);
				Intent viewint = new Intent("main.com.VIEWNOTE");
				startActivity(viewint);
				
				
			}
				
				
				
		});
		
		
		
	
		
	}
	
	
	
	public void setLayout(String name,int age,Bitmap bitmap,int pid)
	{
		 this.name= name;
		 this.age = age;
		 this.bitmap = bitmap;
		this.pid = pid;
		
			
		
	}

}
