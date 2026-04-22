public class TimeBucketCompressor {

    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale. 
     * Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101, 
     * per 20000115 è 20000112, e per 20000123 è 20000123.
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert the long timeBucket to a string to manipulate the date
        String timeBucketStr = String.valueOf(timeBucket);
        
        // Extract year, month, and day from the timeBucket
        int year = Integer.parseInt(timeBucketStr.substring(0, 4));
        int month = Integer.parseInt(timeBucketStr.substring(4, 6));
        int day = Integer.parseInt(timeBucketStr.substring(6, 8));
        
        // Calculate the base day for the compression
        int baseDay = (day - 1) / dayStep * dayStep + 1;
        
        // Handle month overflow
        if (baseDay > 28) {
            if (month == 2) {
                baseDay = 28; // February has 28 days in this context
            } else if (baseDay > 30) {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    baseDay = 30; // April, June, September, November
                } else {
                    baseDay = 31; // January, March, May, July, August, October, December
                }
            }
        }
        
        // Format the new date back to long
        String newTimeBucketStr = String.format("%04d%02d%02d", year, month, baseDay);
        return Long.parseLong(newTimeBucketStr);
    }

    public static void main(String[] args) {
        // Example usage
        long compressedBucket = compressTimeBucket(20000115L, 11);
        System.out.println(compressedBucket); // Output: 20000112
    }
}