public class BinaryLogCalculator {
    /**
     * 计算 $\log_2 (n)$ 的下限值 + 1
     */
    private int computeBinaryLog(int n) {
        int count = 0;
        while (n > 0) {
            n = n >> 1; // divide by 2 using right shift
            count++;
        }
        return count;
    }
}