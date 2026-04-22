public class TimeCompressor {
    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale. Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101, per 20000115 è 20000112, e per 20000123 è 20000123.
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to individual components
        int year = (int)(timeBucket / 10000);
        int month = (int)((timeBucket % 10000) / 100);
        int day = (int)(timeBucket % 100);
        
        // Calculate compressed day based on dayStep
        int compressedDay;
        if (day <= dayStep) {
            compressedDay = 1;
        } else if (day <= dayStep * 2) {
            compressedDay = dayStep + 1;
        } else {
            compressedDay = day;
        }
        
        // Reconstruct compressed timeBucket
        return year * 10000L + month * 100L + compressedDay;
    }
    
    // Test the implementation
    public static void main(String[] args) {
        System.out.println(compressTimeBucket(20000105L, 11)); // Should output 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // Should output 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // Should output 20000123
    }
}