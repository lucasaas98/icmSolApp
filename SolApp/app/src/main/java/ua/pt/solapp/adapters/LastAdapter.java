package ua.pt.solapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.pt.solapp.R;
import ua.pt.solapp.database.entities.District;

public class LastAdapter extends ArrayAdapter {
    Activity context;
    District did;

    public LastAdapter(@NonNull Activity context,District did) {
        super(context, R.layout.item_list, did.getData());
        this.did = did;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_lastlist, null,true);
        TextView district = (TextView) rowView.findViewById(R.id.district);
        TextView globalid = (TextView) rowView.findViewById(R.id.globalid);
        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);
        SharedPreferences pref = this.context.getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        String globalids = pref.getString("globalids", "");
        String[] array =  globalids.split(",");
        checkBox.setChecked(false);
        for (String elem : array){
            if((did.getData().get(position).getGlobalIdLocal()+"").equals(elem)){
                checkBox.setChecked(true);
            }
        }
        district.setText(did.getData().get(position).getLocal()+"");
        globalid.setText(did.getData().get(position).getGlobalIdLocal()+"");

        final Context ctx = this.context;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences pref = ctx.getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                String globalids = pref.getString("globalids", "");
                if (checkBox.isChecked()){
                    editor.putString("globalids", globalids+","+did.getData().get(position).getGlobalIdLocal()+"");
                    editor.commit();
                }else{
                    List<String> ni = new ArrayList<>();
                    for (String elem : array){
                        if(!(did.getData().get(position).getGlobalIdLocal()+"").equals(elem)){
                            ni.add(elem);
                        }
                    }
                    editor.putString("globalids", Arrays.toString(ni.toArray()).replace("[", "").replace("]",""));
                    editor.commit();
                }
            }
        });
        return rowView;
    }
}
