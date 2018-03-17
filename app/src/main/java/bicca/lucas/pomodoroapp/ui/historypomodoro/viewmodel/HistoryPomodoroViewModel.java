package bicca.lucas.pomodoroapp.ui.historypomodoro.viewmodel;

import java.util.ArrayList;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.ui.historypomodoro.interaction.HistoryPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.model.HistoryPomodoro;
import bicca.lucas.pomodoroapp.ui.model.StateEnum;

public class HistoryPomodoroViewModel {

    HistoryPomodoroInteraction interaction;

    @Inject
    public HistoryPomodoroViewModel() {
    }

    public void setInteraction(HistoryPomodoroInteraction interaction) {
        this.interaction = interaction;
    }

    public void loadHistory() {
        interaction.showHistory(getMocks());
    }

    private ArrayList<HistoryPomodoro> getMocks() {
        ArrayList<HistoryPomodoro> pomodoros = new ArrayList<>();
        pomodoros.add(new HistoryPomodoro("25:00", StateEnum.RUNNING, "17/03/2015"));
        pomodoros.add(new HistoryPomodoro("24:00", StateEnum.STOPPED, "16/03/2015"));
        pomodoros.add(new HistoryPomodoro("23:00", StateEnum.FINISHED, "15/03/2015"));
        return pomodoros;
    }

}
