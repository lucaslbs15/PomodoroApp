package bicca.lucas.pomodoroapp.ui.util;

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
}
