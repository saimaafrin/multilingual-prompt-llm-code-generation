public class LogCalculator {

    /**
     * 计算 $\log_2 (n)$ 的下限值 + 1
     */
    private int computeBinaryLog(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    public static void main(String[] args) {
        LogCalculator calculator = new LogCalculator();
        int n = 8; // Example input
        int result = calculator.computeBinaryLog(n);
        System.out.println("The result is: " + result);
    }
}