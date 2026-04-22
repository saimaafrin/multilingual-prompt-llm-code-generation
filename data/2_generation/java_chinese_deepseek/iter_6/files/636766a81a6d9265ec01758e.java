import java.util.*;

public class PrimeUtil {

    /**
     * 返回一个质数，该质数满足 >= desiredCapacity 且与 desiredCapacity 非常接近（如果 desiredCapacity >= 1000，则误差在 11% 以内）。
     * @param desiredCapacity 用户所需的容量。
     * @return 应该用于哈希表的容量。
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        int candidate = desiredCapacity;
        if (candidate % 2 == 0) {
            candidate++;
        }
        while (!isPrime(candidate)) {
            candidate += 2;
        }
        return candidate;
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

    public static void main(String[] args) {
        System.out.println(nextPrime(1000)); // 示例调用
    }
}