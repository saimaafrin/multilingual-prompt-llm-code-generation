import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {
    
    /**
     * 根据 dayStep 重新格式化时间桶的长整型值。例如，当 dayStep == 11 时，20000105 重新格式化后的时间桶为 20000101，
     * 20000115 重新格式化后的时间桶为 20000112，20000123 重新格式化后的时间桶为 20000123。
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to string in format YYYYMMDD
        String dateStr = String.valueOf(timeBucket);
        
        // Parse the date string to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        // Get day of month
        int dayOfMonth = date.getDayOfMonth();
        
        // Calculate which step this date belongs to
        int stepNumber = (dayOfMonth - 1) / dayStep;
        
        // Calculate the first day of this step
        int newDay = stepNumber * dayStep + 1;
        
        // If calculated day is greater than actual day, use the original day
        if (newDay > dayOfMonth) {
            newDay = ((stepNumber - 1) * dayStep) + 1;
        }
        
        // Create new date with adjusted day
        LocalDate newDate = date.withDayOfMonth(newDay);
        
        // Convert back to long
        return Long.parseLong(newDate.format(formatter));
    }
}