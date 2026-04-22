public class FactorialCalculator {

    /** 
     * $n$ का फैक्टरियल निकालें।
     * @param n इनपुट संख्या
     * @return फैक्टरियल
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        long fact = factorial(number);
        System.out.println("Factorial of " + number + " is: " + fact);
    }
}