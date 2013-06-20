package BusinessLogic.com;

import android.os.Parcel;
import android.os.Parcelable;

public class DoctorInfo implements Parcelable{

	 private String tNumber;
	 
	     private String name;
	 
	  
	 
	     public DoctorInfo(String content, String number) {
	 
	         tNumber = number;
	 
	         name = content;
	 
	     }
	 
	  
	 
	     public DoctorInfo(Parcel in) {
	 
	       String data[] = new String[2];
	 
	         in.readStringArray(data);
	 
	         tNumber = data[1];
	 
	         name = data[0];
	 
	     }
	 
	  
	 
	     public void setNumber(String number) {
	 
	         tNumber = number;
	 
	     }
	 
	     public String getNumber() {
	 
	         return tNumber;
	 
	     }
	 
	  
	 
	     public void setContent(String content) {
	
	         name = content;
	 
	     }
	 
	     public String getContent() {
	 
	         return name;
	 
	     }
	 
	  
	 
	     public int describeContents() {
	 
	         return 0;
	 
	     }
	 
	  
	 
	     public void writeToParcel(Parcel dest, int flags) {
	 
	         dest.writeStringArray(new String[] {
	
	             name, tNumber
	
	         });
	 
	  
	 
	     }
	 
	  
	 
	     public static final Parcelable.Creator<DoctorInfo> CREATOR = new Parcelable.Creator<DoctorInfo> () {
	 
	  
	 
	         public DoctorInfo createFromParcel(Parcel source) {
	
	  
	 
	             return new DoctorInfo(source);
	 
	         }
	
	  
	 
	         public DoctorInfo[] newArray(int size) {
	
	  
	
	             return new DoctorInfo[size];
	
	         }
	
	  
	
	     };


}
