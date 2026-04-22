public class HashUtils {
    /**
     * Devuelve un número primo que es >= desiredCapacity y muy cercano a desiredCapacity 
     * (dentro del 11% si desiredCapacity >= 1000).
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
        
        return n;
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}