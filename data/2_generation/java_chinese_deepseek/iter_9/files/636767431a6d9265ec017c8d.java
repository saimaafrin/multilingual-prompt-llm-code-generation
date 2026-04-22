/**
 * 计算 $\log_2 (n)$ 的下限值 + 1
 */
private int computeBinaryLog(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException("n must be a positive integer");
    }
    int log = 0;
    while (n > 1) {
        n = n >> 1;
        log++;
    }
    return log + 1;
}