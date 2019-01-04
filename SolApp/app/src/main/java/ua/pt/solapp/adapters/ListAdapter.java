package ua.pt.solapp.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ua.pt.solapp.R;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.database.entities.WindSpeed;

public class ListAdapter extends ArrayAdapter {
    Activity context;
    WeatherForecast dataList;
    Weather wid;
    District did;
    WindSpeed wind;

    public int[] iconList = {
            R.drawable.sunny,
            R.drawable.sun,
            R.drawable.sun,
            R.drawable.sunny,
            R.drawable.sunny,
            R.drawable.clouds,
            R.drawable.clound_lonely,
            R.drawable.rain_1,
            R.drawable.drizzle,
            R.drawable.rain,
            R.drawable.rain,
            R.drawable.drizzle,
            R.drawable.rain,
            R.drawable.drizzle,
            R.drawable.rain_1,
            R.drawable.drizzle,
            R.drawable.fog,
            R.drawable.fog,
            R.drawable.snowy,
            R.drawable.storm,
            R.drawable.storm_1,
            R.drawable.snow,
            R.drawable.snowflake,
            R.drawable.storm_1,
            R.drawable.clouds,
            R.drawable.sunny,
            R.drawable.fog,
            R.drawable.clouds,
    };



    public ListAdapter(@NonNull Activity context, WeatherForecast nice, District did, Weather wid, WindSpeed wind) {
        super(context, R.layout.item_list, nice.getData());
        this.context = context;
        this.dataList = nice;
        this.did = did;
        this.wid = wid;
        this.wind = wind;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list, null,true);
        TextView day_of_the_week_row = (TextView) rowView.findViewById(R.id.day_of_the_week_row);
        TextView weathertype = (TextView) rowView.findViewById(R.id.weathertype);
        TextView tempmax_min_row = (TextView) rowView.findViewById(R.id.tempmax_min_row);
        ImageView imageview_row = (ImageView) rowView.findViewById(R.id.imageview_row);
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        String[] data = dataList.getDataUpdate().split("T");
        Date noice = null;
        try {
            noice = formatter.parse(data[0]+" "+data[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(noice);
        c.add(Calendar.DATE, position);
        day_of_the_week_row.setText(simpleDateformat.format(c.getTime()));
        weathertype.setText(this.wid.getData().get(dataList.getData().get(position).getIdWeatherType()+1).getDescIdWeatherTypeEN()+"");
        tempmax_min_row.setText(dataList.getData().get(position).getTempMax() + " / " + dataList.getData().get(position).getTempMin() + " ºC");
        imageview_row.setImageResource(iconList[dataList.getData().get(position).getIdWeatherType()]);
        return rowView;
    }
}
