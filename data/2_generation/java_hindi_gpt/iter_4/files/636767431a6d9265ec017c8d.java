public class LogarithmCalculator {
    
    /** 
     * फ़्लोर($\log_2 (n)$) $+ 1$ की गणना करता है
     */
    private int computeBinaryLog(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        return (int) (Math.floor(Math.log(n) / Math.log(2))) + 1;
    }

    public static void main(String[] args) {
        LogarithmCalculator calculator = new LogarithmCalculator();
        int n = 16; // Example input
        int result = calculator.computeBinaryLog(n);
        System.out.println("The result of computeBinaryLog(" + n + ") is: " + result);
    }
}