public class BinaryLogCalculator {
    /**
     * Calcola floor(log_2(n)) + 1
     * Calculates floor(log_2(n)) + 1 by counting the number of bits needed to represent n
     */
    private int computeBinaryLog(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        
        // Count number of bits needed to represent n
        // This effectively calculates floor(log_2(n)) + 1
        return 32 - Integer.numberOfLeadingZeros(n);
    }
}