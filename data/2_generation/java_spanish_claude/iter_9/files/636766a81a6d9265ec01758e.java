public class HashUtils {
    /**
     * Devuelve un número primo que es >= desiredCapacity y muy cercano a desiredCapacity (dentro del 11% si desiredCapacity >= 1000).
     * @param desiredCapacity la capacidad deseada por el usuario.
     * @return la capacidad que se debe utilizar para una tabla hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        
        int n = desiredCapacity;
        if (n % 2 == 0) {
            n++;
        }
        
        while (!isPrime(n)) {
            n += 2;
        }
        
        // Verify that the result is within 11% if desiredCapacity >= 1000
        if (desiredCapacity >= 1000) {
            double ratio = (double) n / desiredCapacity;
            if (ratio > 1.11) {
                throw new IllegalStateException("Could not find a prime number within 11% of desired capacity");
            }
        }
        
        return n;
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
}