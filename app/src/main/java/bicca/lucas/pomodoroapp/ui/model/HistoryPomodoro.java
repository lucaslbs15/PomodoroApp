package bicca.lucas.pomodoroapp.ui.model;

public class HistoryPomodoro {

    private String time;
    private String state;
    private String date;

    public HistoryPomodoro(String time, StateEnum state, String date) {
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
}
