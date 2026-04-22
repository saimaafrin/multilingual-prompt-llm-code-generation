public class HashCapacity {
    public static int getPrimeCapacity(int desiredCapacity) {
        if (desiredCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        
        if (desiredCapacity < 2) {
            return 2;
        }
        
        // Start checking from desiredCapacity
        int num = desiredCapacity;
        
        // If even, add 1 to start checking from next odd number
        if (num % 2 == 0) {
            num++;
        }
        
        // Keep checking until we find a prime number
        while (!isPrime(num)) {
            num += 2;
            
            // Check if we're exceeding 11% threshold for large capacities
            if (desiredCapacity >= 1000 && num > desiredCapacity * 1.11) {
                // Go back to desired capacity and find previous prime
                num = desiredCapacity;
                while (!isPrime(num)) {
                    num--;
                }
                break;
            }
        }
        
        return num;
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
}