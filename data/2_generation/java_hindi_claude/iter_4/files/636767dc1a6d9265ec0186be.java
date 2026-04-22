import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeBucketFormatter {

    /**
     * Follow the dayStep to re-format the time bucket literal long value. Such as, in dayStep == 11, 
     * 20000105 re-formatted time bucket is 20000101, 20000115 re-formatted time bucket is 20000112, 
     * 20000123 re-formatted time bucket is 20000123
     *
     * @param timeBucket The time bucket value to reformat (e.g. 20000105)
     * @param dayStep The step size in days to use for reformatting
     * @return The reformatted time bucket value
     */
    public static long formatTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to string in YYYYMMDD format
        String dateStr = String.valueOf(timeBucket);
        
        // Parse the date string to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        // Get the first day of the month
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        
        // Calculate days since start of month
        long daysSinceStart = ChronoUnit.DAYS.between(firstDayOfMonth, date);
        
        // Calculate which step period this falls into
        int stepPeriod = (int) (daysSinceStart / dayStep);
        
        // Calculate the target date
        LocalDate targetDate = firstDayOfMonth.plusDays(stepPeriod * dayStep + 1);
        
        // If target date is after original date, move back one step
        if (targetDate.isAfter(date)) {
            targetDate = firstDayOfMonth.plusDays((stepPeriod - 1) * dayStep + 1);
        }
        
        // Convert back to long format
        return Long.parseLong(targetDate.format(formatter));
    }
}