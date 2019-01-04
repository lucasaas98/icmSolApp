package ua.pt.solapp.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ua.pt.solapp.activities.MainActivity;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}
