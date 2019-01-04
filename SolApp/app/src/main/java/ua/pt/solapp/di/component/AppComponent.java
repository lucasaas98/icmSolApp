package ua.pt.solapp.di.component;

import android.app.Application;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

import ua.pt.solapp.App;
import ua.pt.solapp.di.module.ActivityModule;
import ua.pt.solapp.di.module.AppModule;
import ua.pt.solapp.di.module.FragmentModule;


@Singleton
@Component(modules={AndroidSupportInjectionModule.class, ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
