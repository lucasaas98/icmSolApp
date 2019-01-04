package ua.pt.solapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import javax.inject.Inject;

import ua.pt.solapp.database.entities.WeatherForecast;
import ua.pt.solapp.repositories.WeatherForecastRepository;

public class WeatherForecastVM extends ViewModel {

    private LiveData<WeatherForecast> weatherForecast;
    private WeatherForecastRepository weatherForecastRepository;

    private final String TAG = "WeatherForecastViewModel";

    @Inject
    public WeatherForecastVM(WeatherForecastRepository weatherIDRepository) {
        this.weatherForecastRepository = weatherIDRepository;
    }

    // ----

    public void init(int weatherForecastI) {
        /*
        if (this.weatherForecast != null) {
            return;
        }
        */
        Log.d(TAG, weatherForecastI+"");
        weatherForecast = weatherForecastRepository.getWeatherForecast(weatherForecastI);
    }

    public LiveData<WeatherForecast> getWeatherForecast() {
        return this.weatherForecast;
    }

}

