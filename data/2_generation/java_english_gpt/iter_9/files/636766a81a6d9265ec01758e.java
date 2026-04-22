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
        int prime = desiredCapacity;
        boolean found = false;

        // Calculate the upper limit for the search
        int upperLimit = desiredCapacity >= 1000 ? (int) (desiredCapacity * 1.11) : Integer.MAX_VALUE;

        while (!found) {
            if (isPrime(prime) && prime <= upperLimit) {
                found = true;
            } else {
                prime++;
            }
        }
        return prime;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
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