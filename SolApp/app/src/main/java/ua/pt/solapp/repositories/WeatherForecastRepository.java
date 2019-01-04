package ua.pt.solapp.repositories;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pt.solapp.App;
import ua.pt.solapp.api.WeatherWebService;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.database.entities.WeatherForecast;

public class WeatherForecastRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 1;
    private final String TAG ="WeatherForecastRepository";

    private final WeatherWebService webservice;
    private final WeatherForecastDao weatherForecastDao;
    private final Executor executor;

    public WeatherForecastRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        this.webservice = webservice;
        this.weatherForecastDao = weatherForecastDao;
        this.executor = executor;
    }

    public LiveData<WeatherForecast> getWeatherForecast(int globalIdLocal) {
        getWeatherForecastValue(globalIdLocal);
        return weatherForecastDao.getWeatherForecastFromGlobalId(globalIdLocal);
    }

    private void getWeatherForecastValue(final int globalIdLocal) {
        executor.execute(() -> {
            webservice.getWeatherForecast(globalIdLocal).enqueue(new Callback<WeatherForecast>() {
                @Override
                public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                    executor.execute(() -> {
                        WeatherForecast wf = response.body();
                        Log.d(TAG, wf.toString());
                        if (wf!=null) {
                            wf.setLastRefresh(new Date());
                            weatherForecastDao.saveWeatherForecast(wf);
                        }
                    });
                }
                @Override
                public void onFailure(Call<WeatherForecast> call, Throwable t) { }
            });
        });
    }

    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}
