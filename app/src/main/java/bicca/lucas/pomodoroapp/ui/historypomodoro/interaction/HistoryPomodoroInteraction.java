package bicca.lucas.pomodoroapp.ui.historypomodoro.interaction;

import java.util.ArrayList;

import bicca.lucas.pomodoroapp.ui.InteractionBase;
import bicca.lucas.pomodoroapp.ui.model.Pomodoro;

public interface HistoryPomodoroInteraction extends InteractionBase {

    void showHistory(ArrayList<Pomodoro> pomodoros);
}
