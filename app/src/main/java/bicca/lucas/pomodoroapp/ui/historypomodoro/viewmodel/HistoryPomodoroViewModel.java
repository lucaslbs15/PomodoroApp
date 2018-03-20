package bicca.lucas.pomodoroapp.ui.historypomodoro.viewmodel;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.ui.historypomodoro.interaction.HistoryPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.repository.PomodoroRepository;

public class HistoryPomodoroViewModel {

    HistoryPomodoroInteraction interaction;

    @Inject
    public HistoryPomodoroViewModel() {
    }

    public void setInteraction(HistoryPomodoroInteraction interaction) {
        this.interaction = interaction;
    }

    public void loadHistory() {
        PomodoroRepository repository = new PomodoroRepository(interaction.getContext());
        interaction.showHistory(repository.listAll());
    }
}
