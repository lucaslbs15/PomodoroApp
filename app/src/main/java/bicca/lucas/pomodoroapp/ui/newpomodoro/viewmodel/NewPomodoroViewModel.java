package bicca.lucas.pomodoroapp.ui.newpomodoro.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.ui.model.StateEnum;
import bicca.lucas.pomodoroapp.ui.newpomodoro.interaction.NewPomodoroInteraction;

public class NewPomodoroViewModel extends BaseObservable {

    private StateEnum state = StateEnum.STOPPED;
    private NewPomodoroInteraction interaction;
    public static final long INITIAL_TIME = 25 * (1000 * 60);

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

    }

}
