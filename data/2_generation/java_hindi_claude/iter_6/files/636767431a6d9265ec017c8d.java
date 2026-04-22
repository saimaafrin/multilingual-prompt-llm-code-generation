public class LogCalculator {
    /**
     * Computes floor(log_2(n)) + 1
     * @param n The input number
     * @return floor(log_2(n)) + 1
     */
    public static int log2Floor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        
        return 32 - Integer.numberOfLeadingZeros(n);
    }
}