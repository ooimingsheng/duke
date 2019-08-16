package seedu.duke.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.text.ParseException;

public class DukeDateFormatter {

    /**
     * DukeDateFormatter has a private constructor to prevent the object from being created directly.
     */
    private DukeDateFormatter() {
    }

    /**
     * Takes a string and tries to convert it into a date if possible.
     * @param str the string that is attempted to be coverted into a date.
     * @return date format of the string if the string is of a "d/M/yyyy HHmm" format and the original string otherwise.
     */
    public static String convertStringToDateIfPossible(String str) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy HHmm");
            Date date = format.parse(str);
            SimpleDateFormat formatter = new SimpleDateFormat("d'suffix' 'of' MMMM yyyy, h.mma");
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return formatter.format(date)
                    .replace("suffix", getDayOfMonthSuffix(localDate.getDayOfMonth()))
                    .replace(".00", "")
                    .replace("AM", "am")
                    .replace("PM", "pm");
        } catch (ParseException exception) {
            return str;
        }
    }

    /**
     * Returns the suffix of the integer n if it is between 1 and 31 and the empty string otherwise.
     * @param n the integer value of the month (i.e. between 1 and 31).
     * @return the suffix of the integer n if it is between 1 and 31 and the empty string otherwise.
     */
    private static String getDayOfMonthSuffix(final int n) {
        if (!(n >= 1 && n <= 31)) {
            return "";
        }
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
        case 1:
            return "st";
        case 2:
            return "nd";
        case 3:
            return "rd";
        default:
            return "th";
        }
    }
}
