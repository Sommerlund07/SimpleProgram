package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static Date toDateFromString_ddMMyyyy(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy HH:mm");
        try {
            Date date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
}
