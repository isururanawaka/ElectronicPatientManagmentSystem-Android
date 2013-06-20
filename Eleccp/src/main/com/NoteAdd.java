package main.com;

import BusinessLogic.com.NoteHandler;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteAdd extends Activity {
	
	public static String pid;
	public static String date;
	public static String note;
	public static String doctor;
	
	@Override
	public  void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addnote);
		
	final Button but =(Button)findViewById(R.id.add);
	final EditText ed = (EditText)findViewById(R.id.editText1);
	   but.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			  CharSequence note =  ed.getText();
			NoteAdd.note = note.toString();
			
			NoteHandler nd = new NoteHandler(NoteAdd.note, pid, doctor, date);// send details to noteadder
			boolean ok = nd.addNote();
			if(ok)
			{
				
				
				Toast.makeText(getApplicationContext(),"Note Added Successfully", 10).show();
			}
			
			
		}
	});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void setdet(String pid,String date,String doctor)
	{
		
		this.pid = pid;
		this.date = date;
		this.doctor = doctor;
		
		
		
		
		
	}

}
