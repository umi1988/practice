import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestDateFormat
{
    public static final String DATE_FORMAT1 = "yyyy/MM/dd";
    public static final String DATE_FORMAT2 = "dd-MM-yyyy";
    public static void main(String[] args) throws ParseException {
        String d1 = "2024/12/10";
        String d2 = "11-12-2024";

        Date validateDOBFormat = null;
        String userInput= null;
        SimpleDateFormat inputFormat = new SimpleDateFormat(DATE_FORMAT1);
        SimpleDateFormat outputFormat = new SimpleDateFormat(DATE_FORMAT2);
        Date dd = outputFormat.parse(d2);
        if(d2.equals(outputFormat.format(dd))){

            try{
                validateDOBFormat= outputFormat.parse(d2);
                userInput = outputFormat.format(validateDOBFormat);
                System.out.println("validateDOBFormat -- " +  validateDOBFormat);
                System.out.println("userInput -- " + userInput);
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Date format not supported...");
        }
    }
}
