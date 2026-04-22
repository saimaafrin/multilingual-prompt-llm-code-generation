import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {
    
    /**
     * 根据 dayStep 重新格式化时间桶的长整型值。例如，当 dayStep == 11 时，20000105 重新格式化后的时间桶为 20000101，
     * 20000115 重新格式化后的时间桶为 20000112，20000123 重新格式化后的时间桶为 20000123。
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to LocalDate
        String dateStr = String.valueOf(timeBucket);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        // Get day of month
        int dayOfMonth = date.getDayOfMonth();
        
        // Calculate compressed day
        int compressedDay;
        if (dayOfMonth <= dayStep) {
            compressedDay = 1;
        } else if (dayOfMonth <= dayStep * 2) {
            compressedDay = dayStep + 1;
        } else {
            compressedDay = dayStep * 2 + 1;
        }
        
        // Create new date with compressed day
        LocalDate compressedDate = date.withDayOfMonth(compressedDay);
        
        // Convert back to long
        return Long.parseLong(compressedDate.format(formatter));
    }
}