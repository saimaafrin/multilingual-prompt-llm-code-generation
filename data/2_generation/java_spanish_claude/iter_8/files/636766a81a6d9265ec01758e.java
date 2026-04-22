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
        
        int num = desiredCapacity;
        if (num % 2 == 0) {
            num++; // Make it odd
        }
        
        while (!isPrime(num)) {
            num += 2;
            
            // Check if we're within 11% for large numbers
            if (desiredCapacity >= 1000) {
                double ratio = (double)num / desiredCapacity;
                if (ratio > 1.11) {
                    // If we've exceeded 11%, return the last prime found
                    return findLastPrime(num);
                }
            }
        }
        
        return num;
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static int findLastPrime(int num) {
        num -= 2;
        while (!isPrime(num)) {
            num -= 2;
        }
        return num;
    }
}