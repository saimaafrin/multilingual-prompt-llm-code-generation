public class PrimeCalculator {
    /**
     * Returns a prime number which is >= desiredCapacity and very close to desiredCapacity 
     * (within 11% if desiredCapacity >= 1000).
     * @param desiredCapacity the capacity desired by the user.
     * @return the capacity which should be used for a hashtable.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        
        // Start with odd number >= desiredCapacity
        int num = desiredCapacity;
        if (num % 2 == 0) {
            num++;
        }
        
        while (!isPrime(num)) {
            num += 2;
        }
        
        return num;
    }
    
    /**
     * Helper method to check if a number is prime
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        // Only need to check up to square root
        int sqrt = (int) Math.sqrt(num);
        
        // Check odd divisors up to sqrt
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}