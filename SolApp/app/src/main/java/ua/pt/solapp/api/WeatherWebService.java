package ua.pt.solapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.database.entities.WindSpeed;

public interface WeatherWebService {

    @GET("/open-data/forecast/meteorology/cities/daily/{globalIdLocal}.json")
    Call<WeatherForecast> getWeatherForecast(@Path("globalIdLocal") int weatherForecast);

    @GET("/open-data/distrits-islands.json")
    Call<District> getDistrictId();

    @GET("/open-data/weather-type-classe.json")
    Call<Weather> getWeatherId();

    @GET("/open-data/wind-speed-daily-classe.json")
    Call<WindSpeed> getWindSpeed();
}
