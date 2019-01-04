package ua.pt.solapp.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.Date;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.database.entities.WindSpeed;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface WeatherForecastDao {

    @Insert(onConflict = REPLACE)
    void saveWeatherForecast(WeatherForecast weatherForecast);

    @Insert(onConflict = REPLACE)
    void saveDistrictID(District district);

    @Insert(onConflict = REPLACE)
    void saveWeatherID(Weather weather);

    @Insert(onConflict = REPLACE)
    void saveWindSpeed(WindSpeed windSpeed);

    @Query("SELECT * FROM weatherforecast WHERE globalIdLocal = :globalIdLocal LIMIT 1")
    LiveData<WeatherForecast> getWeatherForecastFromGlobalId(int globalIdLocal);

    @Query("SELECT * FROM weatherforecast WHERE globalIdLocal = :globalIdLocal AND lastRefresh > :lastRefreshMax LIMIT 1")
    WeatherForecast hasWeatherForecastFromGlobalId(int globalIdLocal, Date lastRefreshMax);

    @Query("SELECT * FROM District ")
    LiveData<District> getGlobalIdLocal();

    @Query("SELECT * FROM Weather ")
    LiveData<Weather> getWeatherType();

    @Query("SELECT * FROM windspeed ")
    LiveData<WindSpeed> getWindSpeed();

}
