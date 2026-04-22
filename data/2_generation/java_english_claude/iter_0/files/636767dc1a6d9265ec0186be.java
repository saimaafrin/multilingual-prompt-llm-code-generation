import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {
    
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to string in YYYYMMDD format
        String dateStr = String.valueOf(timeBucket);
        
        // Parse the date string to LocalDate
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        
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
        
        // Convert back to long in YYYYMMDD format
        return Long.parseLong(compressedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }
}