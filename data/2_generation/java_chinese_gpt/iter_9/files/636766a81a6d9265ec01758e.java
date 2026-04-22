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
        return prime;
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

    public static void main(String[] args) {
        int desiredCapacity = 1000;
        int nextPrimeCapacity = nextPrime(desiredCapacity);
        System.out.println("Next prime capacity: " + nextPrimeCapacity);
    }
}