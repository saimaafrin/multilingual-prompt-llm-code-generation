public class TimeBucketCompressor {

    /**
     * Follow the dayStep to re-format the time bucket literal long value. Such as, in dayStep == 11, 
     * 20000105 re-formatted time bucket is 20000101, 20000115 re-formatted time bucket is 20000112, 
     * 20000123 re-formatted time bucket is 20000123
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract the year and month from the timeBucket
        long yearMonth = timeBucket / 100;
        int day = (int) (timeBucket % 100);

        // Calculate the compressed day
        int compressedDay = ((day - 1) / dayStep) * dayStep + 1;

        // Combine the year, month, and compressed day to form the new time bucket
        return yearMonth * 100 + compressedDay;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(compressTimeBucket(20000105L, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // Output: 20000123
    }
}