import java.util.*;

public class PrimeUtil {

    /**
     * Restituisce un numero primo che è <code>&gt;= desiredCapacity</code> e molto vicino a <code>desiredCapacity</code> (entro l'11% se <code>desiredCapacity &gt;= 1000</code>).
     * @param desiredCapacity la capacità desiderata dall'utente.
     * @return la capacità che dovrebbe essere utilizzata per una tabella hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }

        int prime = desiredCapacity;
        while (!isPrime(prime)) {
            prime++;
        }

        // Se desiredCapacity >= 1000, cerca un primo entro l'11% di desiredCapacity
        if (desiredCapacity >= 1000) {
            int upperBound = (int) (desiredCapacity * 1.11);
            int candidate = desiredCapacity;
            while (candidate <= upperBound) {
                if (isPrime(candidate)) {
                    return candidate;
                }
                candidate++;
            }
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
        System.out.println(nextPrime(1000));  // Esempio di utilizzo
    }
}