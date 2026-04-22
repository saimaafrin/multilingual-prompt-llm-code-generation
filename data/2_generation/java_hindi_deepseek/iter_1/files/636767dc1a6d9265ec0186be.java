public class TimeBucketCompressor {

    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract the year and month from the timeBucket
        long yearMonth = timeBucket / 100;
        int day = (int) (timeBucket % 100);

        // Calculate the compressed day
        int compressedDay = ((day - 1) / dayStep) * dayStep + 1;

        // Combine the year, month, and compressed day to form the new timeBucket
        return yearMonth * 100 + compressedDay;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(compressTimeBucket(20000105, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Output: 20000123
    }
}