package bicca.lucas.pomodoroapp.ui.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import bicca.lucas.pomodoroapp.ui.model.Pomodoro;

@Database(entities = {Pomodoro.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    abstract PomodoroDAO pomodoroDAO();
}
