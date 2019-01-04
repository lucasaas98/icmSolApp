package ua.pt.solapp.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ua.pt.solapp.fragments.WeatherFragment;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract WeatherFragment contributeUserProfileFragment();
}
