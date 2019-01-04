package ua.pt.solapp.repositories;

import android.arch.lifecycle.LiveData;
import java.util.concurrent.Executor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pt.solapp.api.WeatherWebService;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.database.entities.Weather;

public class WeatherRepository {
    private final WeatherWebService webservice;
    private final WeatherForecastDao weatherForecastDao;
    private final Executor executor;

    public WeatherRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        this.webservice = webservice;
        this.weatherForecastDao = weatherForecastDao;
        this.executor = executor;
    }

    public LiveData<Weather> getWeatherID() {
        getWeatherIDs();
        return weatherForecastDao.getWeatherType();
    }

    private void getWeatherIDs() {
        executor.execute(() -> {
            {
                webservice.getWeatherId().enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        executor.execute(() -> {
                            Weather weather = response.body();
                            weatherForecastDao.saveWeatherID(weather);
                        });
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) { }
                });
            }
        });
    }
}
