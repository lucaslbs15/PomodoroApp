package bicca.lucas.pomodoroapp.ui.historypomodoro.viewmodel;

import android.databinding.ObservableField;

public class ItemHistoryPomodoroViewModel {

    public ObservableField<String> time = new ObservableField<>();
    public ObservableField<String> state = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
}
