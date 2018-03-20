package bicca.lucas.pomodoroapp.ui.newpomodoro.viewmodel;

import android.databinding.BaseObservable;
import android.util.Log;

import java.util.Date;

import javax.inject.Inject;

import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.ui.model.Pomodoro;
import bicca.lucas.pomodoroapp.ui.model.StateEnum;
import bicca.lucas.pomodoroapp.ui.newpomodoro.interaction.NewPomodoroInteraction;
import bicca.lucas.pomodoroapp.ui.repository.PomodoroRepository;
import bicca.lucas.pomodoroapp.ui.util.DateUtil;

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
        state = StateEnum.FINISHED;
        PomodoroRepository repository = new PomodoroRepository(interaction.getContext());
        if (repository.save(createPomodoro())) {
            interaction.finishPomodoro();
            interaction.showNotification(interaction.getStringFromId(R.string.notification_pomodoro_finished));
        }
    }

    private Pomodoro createPomodoro() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDate(DateUtil.fromDateToString(new Date(), "dd/MM/yyyy"));
        pomodoro.setState(state.toString());
        pomodoro.setTime(String.valueOf(interaction.getCurrentTime() / 1000));
        return pomodoro;
    }

}
