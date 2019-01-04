package ua.pt.solapp.fragments;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import ua.pt.solapp.R;
import ua.pt.solapp.activities.WebActivity;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.database.entities.DistrictData;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.database.entities.WindSpeed;
import ua.pt.solapp.database.entities.WindSpeedData;
import ua.pt.solapp.view_models.DistrictIdVM;
import ua.pt.solapp.view_models.WeatherForecastVM;
import ua.pt.solapp.view_models.WeatherIdVM;
import ua.pt.solapp.view_models.WindSpeedVM;

public class WeatherFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private WeatherForecastVM WFviewModel;
    private DistrictIdVM DDviewModel;
    private WeatherIdVM WDviewModel;
    private WindSpeedVM WSviewModel;
    String globalIds = null;
    int globalIdLocal = 1110600;
    private int position;

    @BindView(R.id.temperature_frag)
    TextView temperature_frag;
    @BindView(R.id.location_weather_frag)
    TextView location_weather_frag;
    @BindView(R.id.detail_frag)
    TextView detail_frag;
    @BindView(R.id.listview_1)
    ListView listview_1;
    @BindView(R.id.windspeed_frag)
    TextView vento_frag;

    private Context context;
    SharedPreferences pref;
    private static String globalidDef = "1010600";


    public WeatherFragment() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pref = this.context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        globalIds = pref.getString("globalids", globalidDef);
        String[] globalId = globalIds.split(",");
        globalIdLocal = Integer.parseInt(globalId[position]);
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }


    boolean district = false;
    boolean weather = false;
    boolean windspeed = false;

    District did = null;
    Weather wid = null;
    WindSpeed wind = null;

    private void configureViewModel(){
        DDviewModel = ViewModelProviders.of(this, viewModelFactory).get(DistrictIdVM.class);
        DDviewModel.init();
        DDviewModel.getDistrictID().observe(this, districtID -> getDistrictID(districtID));

        WDviewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherIdVM.class);
        WDviewModel.init();
        WDviewModel.getWeatherID().observe(this, weatherID -> getWeatherID(weatherID));

        WSviewModel = ViewModelProviders.of(this, viewModelFactory).get(WindSpeedVM.class);
        WSviewModel.init();
        WSviewModel.getWindSpeed().observe(this, windSpeed -> getWindSpeed(windSpeed));
    }

    private void configureViewAfter(){
        WFviewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherForecastVM.class);
        WFviewModel.init(globalIdLocal);
        WFviewModel.getWeatherForecast().observe(this, weatherForecast -> updateUI(weatherForecast));
    }

    private void updateUI(@Nullable WeatherForecast weatherForecast){
        if (weatherForecast != null){
            this.temperature_frag.setText(weatherForecast.getData().get(0).getTempMax()+"º");
            String weathertype = this.wid.getData().get(weatherForecast.getData().get(0).getIdWeatherType()+1).getDescIdWeatherTypeEN()+"";
            String location = null;
            for(DistrictData elem  : this.did.getData()){
                if(elem.getGlobalIdLocal() == weatherForecast.getGlobalIdLocal())
                    location = elem.getLocal();
            }
            this.location_weather_frag.setText(location + " | " + weathertype);
            String windDir = weatherForecast.getData().get(0).getPredWindDir()+"";
            String windType = null;
            for(WindSpeedData elem : this.wind.getData()){
                if(elem.getClassWindSpeed().equalsIgnoreCase(weatherForecast.getData().get(0).getClassWindSpeed()+""))
                    windType = elem.getDescClassWindSpeedDailyEN();
            }
            this.vento_frag.setText(windDir + " | " + windType);
            ua.pt.solapp.adapters.ListAdapter nice = new ua.pt.solapp.adapters.ListAdapter((Activity) this.context, weatherForecast, did, wid, wind);
            this.listview_1.setAdapter(nice);
            final String loca = location;
            this.detail_frag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("url", "https://www.ipma.pt/en/otempo/prev.localidade.hora/#"+loca+"&"+loca);
                    startActivity(intent);
                }
            });
        }
    }

    private void getDistrictID(@Nullable District district){
        if (district != null){
            did = district;
            this.district = true;
            LastFragment.nice = district;
            if(this.district && weather && windspeed)
                configureViewAfter();
        }
    }

    private void getWeatherID(@Nullable Weather weather){
        if (weather != null){
            wid = weather;
            this.weather =true;
            if(district && this.weather && windspeed)
                configureViewAfter();
        }
    }

    private void getWindSpeed(@Nullable WindSpeed windSpeed){
        if (windSpeed != null){
            wind = windSpeed;
            windspeed = true;
            if(district && weather && windspeed)
                configureViewAfter();
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
