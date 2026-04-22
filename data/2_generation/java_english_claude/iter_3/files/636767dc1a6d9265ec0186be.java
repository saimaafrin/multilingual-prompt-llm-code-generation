import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {
    
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
        
        // Calculate compressed day based on dayStep
        int compressedDay;
        if (dayOfMonth % dayStep == 0) {
            compressedDay = dayOfMonth;
        } else {
            compressedDay = ((dayOfMonth - 1) / dayStep) * dayStep + 1;
        }
        
        // Create new date with compressed day
        LocalDate compressedDate = date.withDayOfMonth(compressedDay);
        
        // Convert back to long format
        return Long.parseLong(compressedDate.format(formatter));
    }
}