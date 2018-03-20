package bicca.lucas.pomodoroapp.ui.newpomodoro.interaction;

import bicca.lucas.pomodoroapp.ui.InteractionBase;

public interface NewPomodoroInteraction extends InteractionBase {

    void runPomodoro();
    void stopPomodoro();
    void finishPomodoro();
    long getCurrentTime();
    void showNotification(String message);
}
