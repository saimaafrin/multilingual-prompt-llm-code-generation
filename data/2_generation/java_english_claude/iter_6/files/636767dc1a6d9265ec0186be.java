import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    
    /**
     * Follow the dayStep to re-format the time bucket literal long value. Such as, in dayStep == 11, 
     * 20000105 re-formatted time bucket is 20000101, 20000115 re-formatted time bucket is 20000112, 
     * 20000123 re-formatted time bucket is 20000123
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to string for parsing
        String dateStr = String.valueOf(timeBucket);
        
        // Parse the date using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        // Get day of month
        int dayOfMonth = date.getDayOfMonth();
        
        // Calculate which step period this date falls into
        int period = (dayOfMonth - 1) / dayStep;
        
        // Calculate the first day of that period
        int newDay = (period * dayStep) + 1;
        
        // Create new date with adjusted day
        LocalDate newDate = date.withDayOfMonth(newDay);
        
        // Convert back to long format
        return Long.parseLong(newDate.format(formatter));
    }
}