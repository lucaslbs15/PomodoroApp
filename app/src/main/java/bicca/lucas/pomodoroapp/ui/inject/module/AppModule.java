package bicca.lucas.pomodoroapp.ui.inject.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import bicca.lucas.pomodoroapp.ui.MainApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MainApplication mainApplication;

    public AppModule(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mainApplication;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mainApplication;
    }
}
