package bicca.lucas.pomodoroapp.ui.model;

import bicca.lucas.pomodoroapp.R;

public enum StateEnum {

    RUNNING(R.string.state_running), FINISHED(R.string.state_finished), STOPPED(R.string.state_stopped);

    private int descriptionId;

    StateEnum(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }
}
