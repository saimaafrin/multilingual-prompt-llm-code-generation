public class PrimeCalculator {
    /**
     * 返回一个质数，该质数满足 <code>&gt;= desiredCapacity</code> 且与 <code>desiredCapacity</code> 非常接近（如果 <code>desiredCapacity &gt;= 1000</code>，则误差在 11% 以内）。
     * @param desiredCapacity 用户所需的容量。
     * @return 应该用于哈希表的容量。
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
            // Check if we exceed the 11% error margin for large numbers
            if (desiredCapacity >= 1000 && num > desiredCapacity * 1.11) {
                // Go back to previous prime number
                num -= 2;
                while (!isPrime(num)) {
                    num -= 2;
                }
                break;
            }
        }
        
        return num;
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}