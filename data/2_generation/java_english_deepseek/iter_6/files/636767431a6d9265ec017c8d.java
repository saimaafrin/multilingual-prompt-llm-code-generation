/**
 * Computes floor(log2(n)) + 1
 */
private int computeBinaryLog(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException("Input must be a positive integer.");
    }
    return 32 - Integer.numberOfLeadingZeros(n);
}