package ua.pt.solapp.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.pt.solapp.api.WeatherWebService;
import ua.pt.solapp.database.WeatherDatabase;
import ua.pt.solapp.database.dao.WeatherForecastDao;
import ua.pt.solapp.repositories.DistrictRepository;
import ua.pt.solapp.repositories.WeatherForecastRepository;
import ua.pt.solapp.repositories.WeatherRepository;
import ua.pt.solapp.repositories.WindSpeedRepository;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    WeatherDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                WeatherDatabase.class, "WeatherDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    WeatherForecastDao provideUserDao(WeatherDatabase database) { return database.weatherForecastDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    WeatherForecastRepository provideWeatherForecastRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        return new WeatherForecastRepository(webservice, weatherForecastDao, executor);
    }

    @Provides
    @Singleton
    DistrictRepository provideDistrictIDRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        return new DistrictRepository(webservice, weatherForecastDao, executor);
    }

    @Provides
    @Singleton
    WeatherRepository provideWeatherIDRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        return new WeatherRepository(webservice, weatherForecastDao, executor);
    }

    @Provides
    @Singleton
    WindSpeedRepository provideWindSpeedRepository(WeatherWebService webservice, WeatherForecastDao weatherForecastDao, Executor executor) {
        return new WindSpeedRepository(webservice, weatherForecastDao, executor);
    }


    // --- NETWORK INJECTION ---

    private static String BASE_URL = "http://api.ipma.pt/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    WeatherWebService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(WeatherWebService.class);
    }

}
