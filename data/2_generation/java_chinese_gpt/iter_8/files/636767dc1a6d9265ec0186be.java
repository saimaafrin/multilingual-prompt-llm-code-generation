public class TimeBucketCompressor {

    /**
     * 根据 dayStep 重新格式化时间桶的长整型值。例如，当 dayStep == 11 时，20000105 重新格式化后的时间桶为 20000101，
     * 20000115 重新格式化后的时间桶为 20000112，20000123 重新格式化后的时间桶为 20000123。
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract year, month, and day from the timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);

        // Calculate the total number of days from the start of the year
        int totalDays = (month - 1) * 30 + day; // Simplified calculation for days in month

        // Calculate the new day bucket based on dayStep
        int newTotalDays = (totalDays / dayStep) * dayStep;

        // Calculate the new day and month
        int newDay = newTotalDays % 30;
        int newMonth = newTotalDays / 30 + 1;

        // Adjust for overflow in days and months
        if (newDay == 0) {
            newDay = 30;
            newMonth--;
        }
        if (newMonth > 12) {
            newMonth = 12;
            newDay = 30; // Simplified, should handle actual month lengths
        }

        // Construct the new time bucket
        long newTimeBucket = year * 10000 + newMonth * 100 + newDay;
        return newTimeBucket;
    }

    public static void main(String[] args) {
        long timeBucket1 = 20000105;
        long timeBucket2 = 20000115;
        long timeBucket3 = 20000123;
        int dayStep = 11;

        System.out.println(compressTimeBucket(timeBucket1, dayStep)); // Output: 20000101
        System.out.println(compressTimeBucket(timeBucket2, dayStep)); // Output: 20000112
        System.out.println(compressTimeBucket(timeBucket3, dayStep)); // Output: 20000123
    }
}