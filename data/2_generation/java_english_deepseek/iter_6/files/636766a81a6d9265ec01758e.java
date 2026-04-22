import java.util.*;

public class PrimeUtil {

    /**
     * Returns a prime number which is >= desiredCapacity and very close to desiredCapacity (within 11% if desiredCapacity >= 1000).
     * @param desiredCapacity the capacity desired by the user.
     * @return the capacity which should be used for a hashtable.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) return 2;
        int candidate = desiredCapacity;
        if (candidate % 2 == 0) candidate++; // Ensure candidate is odd

        while (!isPrime(candidate)) {
            candidate += 2; // Check only odd numbers
        }
        return candidate;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000)); // Example usage
    }
}