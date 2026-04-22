public class FactorialCalculator {

    /**
     * 计算 $n$ 的阶乘。
     * @param n 输入的数字
     * @return 阶乘
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("输入的数字不能为负数");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5; // 示例输入
        System.out.println("阶乘为: " + factorial(n));
    }
}