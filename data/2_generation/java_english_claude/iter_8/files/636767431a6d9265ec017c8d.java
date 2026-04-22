public class BinaryLogCalculator {
    /**
     * Computes floor(log_2(n)) + 1
     * @param n The input number
     * @return floor(log_2(n)) + 1
     */
    private int computeBinaryLog(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        
        int count = 0;
        while (n > 0) {
            n = n >> 1; // Divide by 2 using right shift
            count++;
        }
        
        return count;
    }
}