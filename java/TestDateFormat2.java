import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDateFormat2 {
    public static final String DATE_FORMAT1 = "yyyy/MM/dd";
    public static final String DATE_FORMAT2 = "DD-MM-YYYY";
    public static void main(String[] args) throws ParseException {
       /* String supportedDateString = "2024/12/20";
        String toBeSupportedDateString = "11-12-2024";

        SimpleDateFormat formatter1 = new SimpleDateFormat(DATE_FORMAT1);
        SimpleDateFormat formatter2 = new SimpleDateFormat(DATE_FORMAT2);

        try {
            Calendar cal = Calendar.getInstance();
            System.out.println("The unparsed string is: " + supportedDateString);
            cal.setTime(formatter1.parse(supportedDateString));
            System.out.println("Time parsed: " + cal.getTime());
        }
        catch (ParseException except) {
            except.printStackTrace();
        }
*/

        SimpleDateFormat SDFormat
                = new SimpleDateFormat("MM/ dd/ yy");

        try {
            Calendar cal = Calendar.getInstance();

            // Use of .parse() method to parse
            // Date From String
            String dt = "01/ 29/ 19";
            System.out.println("The unparsed"
                    + " string is: " + dt);

            cal.setTime(SDFormat.parse(dt));
            System.out.println("Time parsed: "
                    + cal.getTime());
        }
        catch (ParseException except) {
            except.printStackTrace();
        }
        }
}
