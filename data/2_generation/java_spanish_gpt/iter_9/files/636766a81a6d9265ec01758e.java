import java.util.Arrays;

public class PrimeCapacity {

    /**
     * Devuelve un número primo que es <code>&gt;= desiredCapacity</code> y muy cercano a <code>desiredCapacity</code> (dentro del 11% si <code>desiredCapacity &gt;= 1000</code>).
     * @param desiredCapacity la capacidad deseada por el usuario.
     * @return la capacidad que se debe utilizar para una tabla hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
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
        int desiredCapacity = 1000;
        int nextPrimeCapacity = nextPrime(desiredCapacity);
        System.out.println("Next prime capacity: " + nextPrimeCapacity);
    }
}