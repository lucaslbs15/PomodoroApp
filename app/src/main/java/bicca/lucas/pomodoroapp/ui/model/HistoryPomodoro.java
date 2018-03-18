package bicca.lucas.pomodoroapp.ui.model;

import android.content.Context;

public class HistoryPomodoro {

    private Context context;

    private String time;
    private String state;
    private String date;

    public HistoryPomodoro(Context context, String time, StateEnum state, String date) {
        this.context = context;
        this.time = time;
        this.state = state.toString();
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public StateEnum getState() {
        return StateEnum.valueOf(state);
    }

    public String getDate() {
        return date;
    }

    public String getStateDescription() {
        return context.getString(StateEnum.valueOf(state).getDescriptionId());
    }
}
