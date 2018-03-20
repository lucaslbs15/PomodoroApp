package bicca.lucas.pomodoroapp.ui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

    public static String fromDateToString(Date date, String formatString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            String dateStr = format.format(date);
            return dateStr;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static long fromChronometerToLong(String chronometerText) {
        long time;
        try {
            SimpleDateFormat format = new SimpleDateFormat("mm:ss");
            Date date = format.parse(chronometerText);
            time = date.getTime();
        } catch (ParseException ex) {
            time = 0;
        }
        return time;
    }

    public static String fromLongToChronometer(long time) {
        String chronometer;
        try {
            SimpleDateFormat format = new SimpleDateFormat("mm:ss");
            chronometer = format.format(new Date(time));
        } catch (Exception ex) {
            chronometer = null;
        }
        return chronometer;
    }
}
