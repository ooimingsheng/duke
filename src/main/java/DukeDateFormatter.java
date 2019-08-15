import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.text.ParseException;

public class DukeDateFormatter {

    private DukeDateFormatter() {}

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

    private static String getDayOfMonthSuffix(final int n) {
        if(!(n >= 1 && n <= 31)) {
            return "";
        }
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
}
