package ua.pt.solapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import butterknife.ButterKnife;
import ua.pt.solapp.R;
import ua.pt.solapp.activities.MainActivity;
import ua.pt.solapp.adapters.LastAdapter;
import ua.pt.solapp.database.entities.District;

public class LastFragment extends Fragment {
    static District nice = null;
    Context ctx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        while(LastFragment.nice== null){}
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ListView lv = (ListView) view.findViewById(R.id.list_view_last);
        Button btm = (Button) view.findViewById(R.id.button_update);
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(ctx, MainActivity.class);
                startActivity(itn);
            }
        });
        lv.setAdapter(new LastAdapter((Activity) this.ctx, this.nice));
        ButterKnife.bind(this, view);
        return view;
    }

    public void setContext(Context context) {
        this.ctx = context;
    }
}
