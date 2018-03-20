package bicca.lucas.pomodoroapp.ui.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import bicca.lucas.pomodoroapp.ui.model.Pomodoro;

@Dao
public interface PomodoroDAO {

    @Insert
    long insert(Pomodoro pomodoro);

    @Query("SELECT * FROM pomodoro ORDER BY id DESC")
    List<Pomodoro> listAll();

}
