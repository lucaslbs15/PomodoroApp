package bicca.lucas.pomodoroapp.ui.newpomodoro.viewmodel;

import android.databinding.BaseObservable;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.ui.model.StateEnum;
import bicca.lucas.pomodoroapp.ui.newpomodoro.interaction.NewPomodoroInteraction;

public class NewPomodoroViewModel extends BaseObservable {

    private StateEnum state = StateEnum.STOPPED;
    private NewPomodoroInteraction interaction;
    public static final long INITIAL_TIME = 1 * (1000 * 60);

    @Inject
    public NewPomodoroViewModel() {
    }

    public void setInteraction(NewPomodoroInteraction interaction) {
        this.interaction = interaction;
    }

    public void onActionClick() {
        switch (state) {
            case RUNNING:
                interaction.stopPomodoro();
                state = StateEnum.STOPPED;
                break;
            case STOPPED:
            case FINISHED:
                interaction.runPomodoro();
                state = StateEnum.RUNNING;
                break;
            default:
                interaction.runPomodoro();
                state = StateEnum.RUNNING;
                break;
        }
    }

    public void validateFinish() {
        if (interaction.getCurrentTime() < 0) {
            finishPomodoro();
        }
    }

    public void finishPomodoro() {
        interaction.finishPomodoro();
        //TODO salvar no banco
        interaction.showNotification(interaction.getStringFromId(R.string.notification_pomodoro_finished));
    }

}
