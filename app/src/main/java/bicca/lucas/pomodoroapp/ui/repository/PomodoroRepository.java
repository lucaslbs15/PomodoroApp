package bicca.lucas.pomodoroapp.ui.repository;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;

import bicca.lucas.pomodoroapp.ui.model.Pomodoro;

public class PomodoroRepository {

    private AppDatabase appDatabase;

    public PomodoroRepository(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "app-database").allowMainThreadQueries().build();
    }

    public boolean save(Pomodoro pomodoro) {
        long id = appDatabase.pomodoroDAO().insert(pomodoro);
        return id > 0;
    }

    public ArrayList<Pomodoro> listAll() {
        return (ArrayList<Pomodoro>) appDatabase.pomodoroDAO().listAll();
    }

}
