public class PrimeCapacity {

    /**
     * 返回一个质数，该质数满足 <code>&gt;= desiredCapacity</code> 且与 <code>desiredCapacity</code> 非常接近（如果 <code>desiredCapacity &gt;= 1000</code>，则误差在 11% 以内）。
     * @param desiredCapacity 用户所需的容量。
     * @return 应该用于哈希表的容量。
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }
        int prime = desiredCapacity;
        boolean found = false;

        while (!found) {
            if (isPrime(prime)) {
                found = true;
            } else {
                prime++;
            }
        }
        
        // Check for the 11% error margin if desiredCapacity >= 1000
        if (desiredCapacity >= 1000) {
            int upperLimit = (int) (desiredCapacity * 1.11);
            if (prime > upperLimit) {
                return nextPrime(upperLimit);
            }
        }
        
        return prime;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int desiredCapacity = 1000;
        int nextPrimeCapacity = nextPrime(desiredCapacity);
        System.out.println("Next prime capacity for " + desiredCapacity + " is: " + nextPrimeCapacity);
    }
}