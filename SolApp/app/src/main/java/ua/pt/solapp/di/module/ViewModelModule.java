package ua.pt.solapp.di.module;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ua.pt.solapp.di.key.ViewModelKey;
import ua.pt.solapp.view_models.DistrictIdVM;
import ua.pt.solapp.view_models.FactoryVM;
import ua.pt.solapp.view_models.WeatherForecastVM;
import ua.pt.solapp.view_models.WeatherIdVM;
import ua.pt.solapp.view_models.WindSpeedVM;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherForecastVM.class)
    abstract ViewModel bindWeatherForecastViewModel(WeatherForecastVM repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DistrictIdVM.class)
    abstract ViewModel bindDistrictIDViewModel(DistrictIdVM repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WeatherIdVM.class)
    abstract ViewModel bindWeatherIDViewModel(WeatherIdVM repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WindSpeedVM.class)
    abstract ViewModel bindWindSpeedViewModel(WindSpeedVM repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryVM factory);
}