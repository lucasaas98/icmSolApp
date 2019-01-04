package ua.pt.solapp.repositories;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pt.solapp.api.WeatherWebService;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.database.entities.District;

public class DistrictRepository {

    private final WeatherWebService webservice;
    private final WeatherForecastDao weatherForecastDao;
    private final Executor executor;

    public DistrictRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        this.webservice = webservice;
        this.weatherForecastDao = weatherForecastDao;
        this.executor = executor;
    }

    public LiveData<District> getDistrict() {
        getDistricts();
        return weatherForecastDao.getGlobalIdLocal();
    }

    private void getDistricts() {
        executor.execute(() -> {
            {
                webservice.getDistrictId().enqueue(new Callback<District>() {
                    @Override
                    public void onResponse(Call<District> call, Response<District> response) {

                        executor.execute(() -> {
                            District district = response.body();
                            weatherForecastDao.saveDistrictID(district);
                        });
                    }
                    @Override
                    public void onFailure(Call<District> call, Throwable t) { }
                });
            }
        });
    }



}
