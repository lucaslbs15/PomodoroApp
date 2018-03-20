package bicca.lucas.pomodoroapp.ui.inject.component;

import bicca.lucas.pomodoroapp.ui.historypomodoro.view.HistoryPomodoroFragment;
import bicca.lucas.pomodoroapp.ui.inject.module.AppModule;
import bicca.lucas.pomodoroapp.ui.newpomodoro.view.NewPomodoroFragment;
import dagger.Component;

@Component(modules = { AppModule.class })
public interface AppComponent {

    void inject(NewPomodoroFragment fragment);
    void inject(HistoryPomodoroFragment fragment);
}
