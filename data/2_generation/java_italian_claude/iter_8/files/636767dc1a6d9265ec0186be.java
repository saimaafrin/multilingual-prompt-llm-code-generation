public class TimeCompressor {
    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale. Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101, per 20000115 è 20000112, e per 20000123 è 20000123.
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Convert timeBucket to string to extract day
        String timeStr = String.valueOf(timeBucket);
        
        // Extract year, month and day
        int year = Integer.parseInt(timeStr.substring(0, 4));
        int month = Integer.parseInt(timeStr.substring(4, 6));
        int day = Integer.parseInt(timeStr.substring(6, 8));
        
        // Calculate compressed day based on dayStep
        int compressedDay;
        if (day % dayStep == 0) {
            compressedDay = day;
        } else {
            compressedDay = ((day - 1) / dayStep) * dayStep + 1;
        }
        
        // Format back to long
        return Long.parseLong(String.format("%04d%02d%02d", year, month, compressedDay));
    }
}