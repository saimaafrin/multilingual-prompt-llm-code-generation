import java.util.*;

public class PrimeUtil {

    /**
     * Restituisce un numero primo che è >= desiredCapacity e molto vicino a desiredCapacity (entro l'11% se desiredCapacity >= 1000).
     * @param desiredCapacity la capacità desiderata dall'utente.
     * @return la capacità che dovrebbe essere utilizzata per una tabella hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        int candidate = desiredCapacity;
        if (candidate % 2 == 0) {
            candidate++;
        }
        while (!isPrime(candidate)) {
            candidate += 2;
            if (desiredCapacity >= 1000 && candidate > desiredCapacity * 1.11) {
                candidate = desiredCapacity;
                if (candidate % 2 == 0) {
                    candidate++;
                }
            }
        }
        return candidate;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000));  // Esempio di utilizzo
    }
}