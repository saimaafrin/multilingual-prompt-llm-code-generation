public class TimeBucketCompressor {

    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     *
     * @param timeBucket समय बकेट का लम्बा मान (YYYYMMDD प्रारूप में)
     * @param dayStep दिन का चरण
     * @return फिर से प्रारूपित समय बकेट
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract year, month, and day from the timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);

        // Calculate the new day based on the dayStep
        int newDay = ((day - 1) / dayStep) * dayStep + 1;

        // Reconstruct the new timeBucket
        long newTimeBucket = year * 10000L + month * 100L + newDay;

        return newTimeBucket;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(compressTimeBucket(20000105, 11)); // Expected: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Expected: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Expected: 20000123
    }
}