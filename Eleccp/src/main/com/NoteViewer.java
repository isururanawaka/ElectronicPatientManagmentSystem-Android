package main.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteViewer extends Activity{
	
	private TextView tv;
	private static String notes;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noteviewer);
	 tv =  (TextView)findViewById(R.id.addednotes);
		
		tv.setText(notes);
		
		
	}
	
	public void setNotes(StringBuffer notes)
	{
		
		if(notes != null)
		{
			this.notes = notes.toString();
			
			
		}
		else
			this.notes= "No notes to Display";
		
		
	}

}
