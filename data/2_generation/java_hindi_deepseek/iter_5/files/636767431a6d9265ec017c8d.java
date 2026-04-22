/**
 * फ़्लोर($\log_2 (n)$) $+ 1$ की गणना करता है
 */
private int computeBinaryLog(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException("Input must be a positive integer.");
    }
    int log = 0;
    while (n > 1) {
        n = n >> 1;
        log++;
    }
    return log + 1;
}