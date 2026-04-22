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
            num++; // 确保从奇数开始检查
        }
        
        while (!isPrime(num)) {
            num += 2;
            // 检查是否超出误差范围
            if (desiredCapacity >= 1000 && 
                (double)(num - desiredCapacity) / desiredCapacity > 0.11) {
                // 回退到最后一个符合条件的质数
                while (!isPrime(num - 2)) {
                    num -= 2;
                }
                return num - 2;
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
}