public class FactorialCalculator {
    
    /**
     * 计算 $n$ 的阶乘。
     * @param n 输入的数字
     * @return 阶乘
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        long result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}