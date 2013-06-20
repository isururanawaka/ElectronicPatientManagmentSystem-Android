package BusinessLogic.com;

import android.os.Parcel;
import android.os.Parcelable;

public class PatientInfo implements Parcelable{

	 private String name;
	 private String pid;
	 private String telphone;
	 
	     	 
	  
	 
	     public PatientInfo(String name, String pid,String telphone) {
	 
	        this.name = name;
	        this.pid = pid;
	        this.telphone = telphone;
	 
	     }
	 
	  
	 
	     public PatientInfo(Parcel in) {
	 
	       String data[] = new String[3];
	 
	         in.readStringArray(data);
	 
	         this.name = data[0];
	 
	         this.pid = data[1];
	         this.telphone = data[2];
	 
	     }
	 
	  
	 
	     public void setName(String name) {
	 
	         this.name = name;
	 
	     }
	 
	     public String getname() {
	 
	         return this.name;
	 
	     }
	 
	  
	 
	     public void setPID(String PID) {
	
	         this.pid = PID;
	 
	     }
	 
	     public String getPID() {
	 
	         return this.pid;
	 
	     }
	 
	     public void setTelephone(String tele) {
	    		
	         this.telphone= tele;
	 
	     }
	 
	     public String getTelephone() {
	 
	         return this.telphone;
	 
	     }
	 
	 
	     public int describeContents() {
	 
	         return 0;
	 
	     }
	 
	  
	 
	     public void writeToParcel(Parcel dest, int flags) {
	 
	         dest.writeStringArray(new String[] {
	
	             this.name, this.pid,this.telphone
	
	         });
	 
	  
	 
	     }
	 
	  
	 
	     public static final Parcelable.Creator<PatientInfo> CREATOR = new Parcelable.Creator<PatientInfo> () {
	 
	  
	 
	         public PatientInfo createFromParcel(Parcel source) {
	
	  
	 
	             return new PatientInfo(source);
	 
	         }
	
	  
	 
	         public PatientInfo[] newArray(int size) {
	
	  
	
	             return new PatientInfo[size];
	
	         }
	
	  
	
	     };


}
