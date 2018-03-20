package bicca.lucas.pomodoroapp.ui.historypomodoro.viewmodel;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.ui.event.ReloadHistoryEvent;
import bicca.lucas.pomodoroapp.ui.historypomodoro.interaction.HistoryPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.repository.PomodoroRepository;

public class HistoryPomodoroViewModel {

    HistoryPomodoroInteraction interaction;

    @Inject
    public HistoryPomodoroViewModel() {
        EventBus.getDefault().register(this);
    }

    public void setInteraction(HistoryPomodoroInteraction interaction) {
        this.interaction = interaction;
    }

    public void loadHistory() {
        PomodoroRepository repository = new PomodoroRepository(interaction.getContext());
        interaction.showHistory(repository.listAll());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReloadHistoryEvent(ReloadHistoryEvent event) {
        Log.i("Bicca", "onReloadHistoryEvent()");
        loadHistory();
    }
}
