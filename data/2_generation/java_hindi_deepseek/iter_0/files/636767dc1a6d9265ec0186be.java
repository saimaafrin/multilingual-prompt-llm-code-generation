import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert the timeBucket to a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(String.valueOf(timeBucket), formatter);

        // Calculate the day of the month to adjust
        int dayOfMonth = date.getDayOfMonth();
        int adjustedDay = ((dayOfMonth - 1) / dayStep) * dayStep + 1;

        // Create a new date with the adjusted day
        LocalDate adjustedDate = date.withDayOfMonth(adjustedDay);

        // Convert the adjusted date back to a long in the format yyyyMMdd
        return Long.parseLong(adjustedDate.format(formatter));
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(compressTimeBucket(20000105L, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // Output: 20000123
    }
}