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
        
        int result = 0;
        while (n > 1) {
            n = n >> 1; // Divide by 2 using bit shift
            result++;
        }
        return result + 1;
    }
}