public class HashUtils {
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        
        int num = desiredCapacity;
        if (num % 2 == 0) {
            num++; // Start with odd number
        }
        
        while (!isPrime(num)) {
            num += 2;
        }
        
        return num;
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}