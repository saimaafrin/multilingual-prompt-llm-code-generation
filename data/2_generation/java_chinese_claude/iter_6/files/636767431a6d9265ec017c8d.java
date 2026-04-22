public class BinaryLogCalculator {
    /**
     * 计算 $\log_2 (n)$ 的下限值 + 1
     */
    private int computeBinaryLog(int n) {
        int count = 0;
        while (n > 1) {
            n = n >> 1; // divide by 2
            count++;
        }
        return count + 1;
    }
}