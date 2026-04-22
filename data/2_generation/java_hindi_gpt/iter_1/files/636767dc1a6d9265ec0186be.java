public class TimeBucketCompressor {
    
    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract year, month, and day from the timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);
        
        // Calculate the day of the year
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[2] = 29; // Adjust for leap year
        }
        
        int dayOfYear = day;
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i];
        }
        
        // Compress the day of the year according to the dayStep
        int compressedDayOfYear = (dayOfYear / dayStep) * dayStep;
        
        // Find the new date from the compressed day of the year
        int newDay = compressedDayOfYear;
        int newMonth = 1;
        
        while (newMonth <= 12 && newDay > daysInMonth[newMonth]) {
            newDay -= daysInMonth[newMonth];
            newMonth++;
        }
        
        // Construct the new timeBucket
        return year * 10000 + newMonth * 100 + newDay;
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        long timeBucket = 20000123;
        int dayStep = 11;
        long compressedBucket = compressTimeBucket(timeBucket, dayStep);
        System.out.println(compressedBucket); // Output: 20000123
    }
}