package ua.pt.solapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ua.pt.solapp.R;
import ua.pt.solapp.fragments.LastFragment;
import ua.pt.solapp.fragments.WeatherFragment;


public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private static String globalidDef = "1110600";
    String globalids = null;

    private ViewPager viewpager;
    private MyPagerAdapter sldadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = this.getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        globalids = pref.getString("globalids", "");
        if(globalids.equalsIgnoreCase("")){
            editor.putString("globalids", "1010500,1030300,1040200,1050200" );
            editor.commit();
        }
        super.onCreate(savedInstanceState=null);
        int size = globalids.split(",").length;
        //Log.d("heysize", size+"");
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.view_pager_main);
        sldadapter = new MyPagerAdapter(getSupportFragmentManager(), this, size+1);
        viewpager.setAdapter(sldadapter);
        this.configureDagger();
    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 0;
        Context context;

        public MyPagerAdapter(FragmentManager fragmentManager, Context ctx, int size) {
            super(fragmentManager);
            this.context = ctx;
            MyPagerAdapter.NUM_ITEMS = size;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == NUM_ITEMS-1){
                LastFragment nice = new LastFragment();
                nice.setContext(this.context);
                return nice;
            }else{
                WeatherFragment oof = new WeatherFragment();
                oof.setPosition(position);
                oof.setContext(this.context);
                return oof;
            }
        }
    }

    private void configureDagger(){
        AndroidInjection.inject(this);
    }
}
