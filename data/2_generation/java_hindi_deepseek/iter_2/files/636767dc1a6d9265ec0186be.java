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

        // Calculate the day of the month to determine the compressed day
        int dayOfMonth = date.getDayOfMonth();
        int compressedDay = ((dayOfMonth - 1) / dayStep) * dayStep + 1;

        // Create the compressed date
        LocalDate compressedDate = LocalDate.of(date.getYear(), date.getMonth(), compressedDay);

        // Convert the compressed date back to a long in the format yyyyMMdd
        return Long.parseLong(compressedDate.format(formatter));
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(compressTimeBucket(20000105, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Output: 20000123
    }
}