public class BinaryLogCalculator {
    /**
     * 计算 $\log_2 (n)$ 的下限值 + 1
     * @param n 输入的正整数
     * @return $\log_2 (n)$ 的下限值 + 1
     */
    private static int computeBinaryLog(int n) {
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

    public static void main(String[] args) {
        int n = 10; // 示例输入
        System.out.println("Log2(" + n + ") 的下限值 + 1: " + computeBinaryLog(n));
    }
}