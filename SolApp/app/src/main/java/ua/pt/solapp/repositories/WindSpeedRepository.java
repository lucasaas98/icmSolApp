package ua.pt.solapp.repositories;

import android.arch.lifecycle.LiveData;
import java.util.concurrent.Executor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pt.solapp.api.WeatherWebService;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.database.entities.WindSpeed;

public class WindSpeedRepository {
    private final WeatherWebService webservice;
    private final WeatherForecastDao weatherForecastDao;
    private final Executor executor;

    public WindSpeedRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        this.webservice = webservice;
        this.weatherForecastDao = weatherForecastDao;
        this.executor = executor;
    }

    public LiveData<WindSpeed> getWindSpeed() {
        getWindSpeedValues();
        return weatherForecastDao.getWindSpeed();
    }

    private void getWindSpeedValues() {
        executor.execute(() -> {
            {
                webservice.getWindSpeed().enqueue(new Callback<WindSpeed>() {
                    @Override
                    public void onResponse(Call<WindSpeed> call, Response<WindSpeed> response) {
                        executor.execute(() -> {
                            WindSpeed windSpeed = response.body();
                            weatherForecastDao.saveWindSpeed(windSpeed);
                        });
                    }
                    @Override
                    public void onFailure(Call<WindSpeed> call, Throwable t) { }
                });
            }
        });
    }
}
