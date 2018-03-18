package bicca.lucas.pomodoroapp.ui;

import android.app.Application;

import bicca.lucas.pomodoroapp.ui.inject.component.AppComponent;
import bicca.lucas.pomodoroapp.ui.inject.component.DaggerAppComponent;
import bicca.lucas.pomodoroapp.ui.inject.module.AppModule;

public class MainApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this)).build();
        }
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
