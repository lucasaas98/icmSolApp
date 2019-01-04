package ua.pt.solapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import ua.pt.solapp.database.converter.DBConverter;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.database.entities.DistrictData;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.database.entities.WeatherData;
import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.database.entities.WeatherForecastData;
import ua.pt.solapp.database.entities.WindSpeed;
import ua.pt.solapp.database.entities.WindSpeedData;

@Database(entities = {WeatherForecast.class, District.class, Weather.class, WindSpeed.class, WeatherForecastData.class, DistrictData.class, WeatherData.class, WindSpeedData.class}, version = 1, exportSchema = false)
@TypeConverters(DBConverter.class)
public abstract class WeatherDatabase extends RoomDatabase {

    private static volatile WeatherDatabase INSTANCE;

    public abstract WeatherForecastDao weatherForecastDao();
}
