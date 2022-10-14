package rdp.fit.bstu.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DataListAdapter extends ArrayAdapter<Data> {
    private static final String TAG = "DataListAdapter";
    private Context mContext;
    int mResource;
    public DataListAdapter(Context context, int resource, ArrayList<Data> objects) {
        super(context, resource, objects);
        mContext = context;
    }
    @NotNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String Image = getItem(position)._Image;
        String Name = getItem(position)._Name;
        String Category = getItem(position)._Category;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        TextView category = (TextView) convertView.findViewById(R.id.textView2);

        name.setText(Name);
        category.setText(Category);

        return convertView;
    }
}
