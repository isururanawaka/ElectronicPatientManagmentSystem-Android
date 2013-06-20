package BusinessLogic.com;

import java.util.List;

import main.com.R;

import BusinessLogic.com.SmsInfoAdapter.ViewHolder;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DoctorInfoAdapter extends ArrayAdapter<DoctorInfo> {

	 

    public DoctorInfoAdapter(Activity a, List<DoctorInfo> list) {
        super(a, 0, list);
 
    }

 

    @Override

    public View getView(int pos, View convertView, ViewGroup parent) {

 

        ViewHolder holder = null;

        if(convertView == null) {
            Activity a = (Activity)getContext();
            LayoutInflater inflater = a.getLayoutInflater();
            holder = new ViewHolder();

           convertView = inflater.inflate(R.layout.doctorlist, null);

            holder.tdNumber = (TextView)convertView.findViewById(R.id.dcnumber);

           holder.tdName = (TextView)convertView.findViewById(R.id.dcname);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder)convertView.getTag();

        }

 

        DoctorInfo entry = getItem(pos);

        if(entry != null) {

            holder.tdNumber.setText(entry.getNumber());

            holder.tdName.setText(entry.getContent());

        }

 

        return convertView;

    }

 

    static class ViewHolder {

        TextView tdNumber;

        TextView tdName;

    }
}
