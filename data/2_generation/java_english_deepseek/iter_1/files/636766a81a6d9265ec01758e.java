import java.util.*;

public class PrimeUtil {

    /**
     * Returns a prime number which is >= desiredCapacity and very close to desiredCapacity (within 11% if desiredCapacity >= 1000).
     * @param desiredCapacity the capacity desired by the user.
     * @return the capacity which should be used for a hashtable.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        int prime = desiredCapacity;
        if (prime % 2 == 0) {
            prime++;
        }
        while (!isPrime(prime)) {
            prime += 2;
        }
        return prime;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000)); // Example usage
    }
}