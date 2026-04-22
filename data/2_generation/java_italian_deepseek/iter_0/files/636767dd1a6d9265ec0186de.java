public class CacheUtil {

    /**
     * Determines if the given timestamp has expired based on the expired threshold.
     *
     * @param timestamp        current time
     * @param expiredThreshold duration between the last update and the moment when it should be removed from the cache
     * @return true if the metrics should be removed from the cache
     */
    public static boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        // Example usage
        long timestamp = System.currentTimeMillis() - 10000; // 10 seconds ago
        long expiredThreshold = 5000; // 5 seconds threshold
        boolean expired = isExpired(timestamp, expiredThreshold);
        System.out.println("Is expired: " + expired); // Should print "Is expired: true"
    }
}