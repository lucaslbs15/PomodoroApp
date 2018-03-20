package bicca.lucas.pomodoroapp.ui.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;

@Entity(tableName = "pomodoro")
public class Pomodoro {

    @Ignore
    private Context context;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "state")
    private String state;
    @ColumnInfo(name = "date")
    private String date;

    public Pomodoro() {
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getState() {
        return state;
    }

    public String getDate() {
        return date;
    }

    public String getStateDescription() {
        return context.getString(StateEnum.valueOf(state).getDescriptionId());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
