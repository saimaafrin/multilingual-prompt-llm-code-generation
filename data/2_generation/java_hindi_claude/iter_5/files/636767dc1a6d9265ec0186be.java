import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeBucketFormatter {

    public static long formatTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to LocalDate
        String dateStr = String.valueOf(timeBucket);
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        
        // Get first day of month
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        
        // Calculate days between first day of month and given date
        long daysBetween = ChronoUnit.DAYS.between(firstDayOfMonth, date);
        
        // Calculate which step bucket the date falls into
        int stepBucket = (int)(daysBetween / dayStep);
        
        // Get the formatted date by adding (stepBucket * dayStep) days to first day of month
        LocalDate formattedDate = firstDayOfMonth.plusDays(stepBucket * dayStep);
        
        // Convert back to long format
        return Long.parseLong(formattedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }
    
    // Example usage
    public static void main(String[] args) {
        System.out.println(formatTimeBucket(20000105, 11)); // Prints 20000101
        System.out.println(formatTimeBucket(20000115, 11)); // Prints 20000112
        System.out.println(formatTimeBucket(20000123, 11)); // Prints 20000123
    }
}