package ua.pt.solapp.database.converter;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import ua.pt.solapp.database.entities.DistrictData;
import ua.pt.solapp.database.entities.WeatherData;
import ua.pt.solapp.database.entities.WeatherForecastData;
import ua.pt.solapp.database.entities.WindSpeedData;

public class DBConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static String fromWeatherForecastData (List<WeatherForecastData> weatherForecastDataList) {

        if (weatherForecastDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WeatherForecastData>>(){}.getType();

        String json = gson.toJson(weatherForecastDataList, type);
        return json;
    }

    @TypeConverter
    public static List<WeatherForecastData> toWeatherForecastData (String weatherForecastData) {

        if (weatherForecastData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WeatherForecastData>>(){}.getType();

        List<WeatherForecastData> weatherForecastDataList = gson.fromJson(weatherForecastData, type);
        return weatherForecastDataList;
    }

    @TypeConverter
    public static String fromDistrictIDData (List<DistrictData> districtDataList) {

        if (districtDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<DistrictData>>(){}.getType();

        String json = gson.toJson(districtDataList, type);
        return json;
    }

    @TypeConverter
    public static List<DistrictData> toDistrictIDData (String districtIDData) {

        if (districtIDData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<DistrictData>>(){}.getType();

        List<DistrictData> districtDataList = gson.fromJson(districtIDData, type);
        return districtDataList;
    }

    @TypeConverter
    public static String fromWeatherIDData (List<WeatherData> weatherDataList) {

        if (weatherDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WeatherData>>(){}.getType();

        String json = gson.toJson(weatherDataList, type);
        return json;
    }

    @TypeConverter
    public static List<WeatherData> toWeatherIDData (String weatherIDData) {

        if (weatherIDData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WeatherData>>(){}.getType();

        List<WeatherData> weatherDataList = gson.fromJson(weatherIDData, type);
        return weatherDataList;
    }

    @TypeConverter
    public static String fromWindSpeedData (List<WindSpeedData> windSpeedDataList) {

        if (windSpeedDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WindSpeedData>>(){}.getType();

        String json = gson.toJson(windSpeedDataList, type);
        return json;
    }

    @TypeConverter
    public static List<WindSpeedData> toWindSpeedData (String windSpeedData) {

        if (windSpeedData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WindSpeedData>>(){}.getType();

        List<WindSpeedData> windSpeedDataList = gson.fromJson(windSpeedData, type);
        return windSpeedDataList;
    }
}
