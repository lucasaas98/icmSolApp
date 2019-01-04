package ua.pt.solapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import javax.inject.Inject;
import ua.pt.solapp.database.entities.Weather;
import ua.pt.solapp.repositories.WeatherRepository;

public class WeatherIdVM extends ViewModel {

    private LiveData<Weather> weatherID;
    private WeatherRepository weatherRepository;

    @Inject
    public WeatherIdVM(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void init() {
        if (this.weatherID != null) {
            return;
        }
        weatherID = weatherRepository.getWeatherID();
    }

    public LiveData<Weather> getWeatherID() {
        return this.weatherID;
    }
}
