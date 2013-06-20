package BusinessLogic.com;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import Network.ServerConnetor;
import main.com.EleccpActivity;

public class LoginHandler {
	
	private String username;
	private String password;
	private String url;
	private String result;
	private boolean connected =false;
	private int privilage;
	
	public LoginHandler(String username,String password)
	{
		
		this.username = username;
		this.password = password;
		final String server = EleccpActivity.server;
		this.url ="http://"+server+"/project/logintablegetter.php";

			
	}
	
	
public boolean Validate()//is login validated
{
boolean ok = authenticate();	


return ok;


}
	
	/**
	 * 
	 * @return
	 */
private boolean authenticate()// function for send username and password of loger
{
	
	ServerConnetor  con = new ServerConnetor();
	 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	 nameValuePairs.add(new BasicNameValuePair("username",this.username));
	 nameValuePairs.add(new BasicNameValuePair("password",this.password));
result = con.authenticate(nameValuePairs, this.url);
if(result != null)
{
String array[] =calculate(result);

if(array!= null)
{
	
   if(this.password.equals(array[1]))
   {
	 connected = true;  
	 privilage = Integer.parseInt(array[2]);
	   
	   }
   }

}
else{
	
	
	connected = false;
	
}






return connected;


}
	
private String[] calculate(String result) // data decoder function from json object
{
	 
	 String array[]=null;
	
	
  //paring data
  String  username;
  String password;
  int privillage;
  
  try{
     JSONArray   jArray = new JSONArray(result);
        JSONObject json_data=null;
        array = new String[3*jArray.length()];
        int count=0;
        for(int i=0;i<jArray.length();i++){
               json_data = jArray.getJSONObject(i);
              username=json_data.getString("username");
              password=json_data.getString("password");
              privillage =json_data.getInt("privillage");
              
                array[count]=username; 
                  count++;
                array[count]=password; 
                 count++;
                 array[count]=String.valueOf(privillage);
                 count++;
                 
           }
        }
        catch(JSONException e1){
        	e1.printStackTrace();
      	 
        } catch (ParseException e1) {
  			e1.printStackTrace();
  	}




return array;

}
	
public int getPrivillage()// give privillage level of the loger
{
	
    return privilage;



}
	
	

}
