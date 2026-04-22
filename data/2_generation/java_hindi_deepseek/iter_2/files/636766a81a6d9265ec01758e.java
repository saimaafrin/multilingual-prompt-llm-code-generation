import java.util.*;

public class PrimeUtil {

    /**
     * एक प्रमुख संख्या लौटाता है जो <code>&gt;= desiredCapacity</code> है और <code>desiredCapacity</code> के बहुत करीब है (यदि <code>desiredCapacity &gt;= 1000</code> है तो 11% के भीतर)।
     * @param desiredCapacity उपयोगकर्ता द्वारा इच्छित क्षमता।
     * @return वह क्षमता जो हैशटेबल के लिए उपयोग की जानी चाहिए।
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }

        int candidate = desiredCapacity;
        while (true) {
            if (isPrime(candidate)) {
                if (desiredCapacity >= 1000) {
                    int upperBound = (int) (desiredCapacity * 1.11);
                    if (candidate <= upperBound) {
                        return candidate;
                    }
                } else {
                    return candidate;
                }
            }
            candidate++;
        }
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
        System.out.println(nextPrime(1000)); // Example usage
    }
}