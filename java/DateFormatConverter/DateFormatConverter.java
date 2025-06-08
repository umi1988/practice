package DateFormatConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormatConverter {
    public static void main(String[] args) {
        String dateString = "2024-07-05"; // Original date string
        String originalFormat = "yyyy-MM-dd";
        String desiredFormat = "MM/dd/yyyy";
        String desiredFormat1 = "MM-dd-yyyy";

        SimpleDateFormat originalFormatter = new SimpleDateFormat(originalFormat);
        SimpleDateFormat desiredFormatter = new SimpleDateFormat(desiredFormat);
        SimpleDateFormat desiredFormatter1 = new SimpleDateFormat(desiredFormat1);
        try {
            Date date = originalFormatter.parse(dateString);
            System.out.println("DATE - " + date);
            String formattedDate = desiredFormatter.format(date);
            System.out.println("Formatted Date: " + formattedDate);
            String formattedDate1 = desiredFormatter1.format(date);
            System.out.println("Formatted Date: " + formattedDate1);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
    }
}
