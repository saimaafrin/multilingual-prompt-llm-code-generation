import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert the timeBucket to a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(String.valueOf(timeBucket), formatter);

        // Calculate the day of the month to adjust
        int dayOfMonth = date.getDayOfMonth();
        int adjustedDay = ((dayOfMonth - 1) / dayStep) * dayStep + 1;

        // Create a new date with the adjusted day
        LocalDate adjustedDate = date.withDayOfMonth(adjustedDay);

        // Convert the adjusted date back to a long
        return Long.parseLong(adjustedDate.format(formatter));
    }

    public static void main(String[] args) {
        // Example usage
        long timeBucket1 = 20000105;
        int dayStep1 = 11;
        System.out.println(compressTimeBucket(timeBucket1, dayStep1)); // Output: 20000101

        long timeBucket2 = 20000115;
        int dayStep2 = 11;
        System.out.println(compressTimeBucket(timeBucket2, dayStep2)); // Output: 20000112

        long timeBucket3 = 20000123;
        int dayStep3 = 11;
        System.out.println(compressTimeBucket(timeBucket3, dayStep3)); // Output: 20000123
    }
}