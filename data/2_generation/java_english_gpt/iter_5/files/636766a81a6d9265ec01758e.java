import java.util.Arrays;

public class PrimeCapacity {

    /** 
     * Returns a prime number which is <code>&gt;= desiredCapacity</code> and very close to <code>desiredCapacity</code> (within 11% if <code>desiredCapacity &gt;= 1000</code>).
     * @param desiredCapacity the capacity desired by the user.
     * @return the capacity which should be used for a hashtable.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }
        if (desiredCapacity == 2) {
            return 2;
        }

        int upperLimit = desiredCapacity;
        if (desiredCapacity >= 1000) {
            upperLimit = (int) (desiredCapacity * 1.11);
        }

        for (int i = desiredCapacity; i <= upperLimit; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return upperLimit; // Fallback, should not reach here
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000)); // Example usage
        System.out.println(nextPrime(15));   // Example usage
    }
}