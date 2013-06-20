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

public class PatientInfoAdapter extends ArrayAdapter<PatientInfo> {

	 

    public PatientInfoAdapter(Activity a, List<PatientInfo> list) {
        super(a, 0, list);
 
    }

 

    @Override

    public View getView(int pos, View convertView, ViewGroup parent) {

 

        ViewHolder holder = null;

        if(convertView == null) {
            Activity a = (Activity)getContext();
            LayoutInflater inflater = a.getLayoutInflater();
            holder = new ViewHolder();

           convertView = inflater.inflate(R.layout.listitem, null);

           holder.name = (TextView)convertView.findViewById(R.id.tvname);

            holder.pid = (TextView)convertView.findViewById(R.id.tvpid);
            holder.telephone = (TextView)convertView.findViewById(R.id.tvtelephone);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder)convertView.getTag();

        }

 

        PatientInfo entry = getItem(pos);

        if(entry != null) {

            holder.name.setText(entry.getname());

            holder.pid.setText(entry.getPID());
            holder.telephone.setText(entry.getTelephone());

        }

 

        return convertView;

    }

 

    static class ViewHolder {

        TextView name;

        TextView pid;
       
        TextView telephone;

    }
}
