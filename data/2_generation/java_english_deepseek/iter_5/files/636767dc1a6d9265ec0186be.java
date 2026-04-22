import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * Follow the dayStep to re-format the time bucket literal long value. Such as, in dayStep == 11, 20000105 re-formatted time bucket is 20000101, 20000115 re-formatted time bucket is 20000112, 20000123 re-formatted time bucket is 20000123
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert the timeBucket to a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(String.valueOf(timeBucket), formatter);

        // Calculate the new day based on the dayStep
        int day = date.getDayOfMonth();
        int newDay = ((day - 1) / dayStep) * dayStep + 1;

        // Create a new LocalDate with the adjusted day
        LocalDate newDate = date.withDayOfMonth(newDay);

        // Convert the new date back to a long value
        return Long.parseLong(newDate.format(formatter));
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(compressTimeBucket(20000105L, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // Output: 20000123
    }
}