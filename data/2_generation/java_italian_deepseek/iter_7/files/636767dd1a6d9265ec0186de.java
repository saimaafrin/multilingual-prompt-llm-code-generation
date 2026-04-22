public class CacheUtil {

    /**
     * Determines if the metrics should be removed from the cache based on the current timestamp and the expired threshold.
     *
     * @param timestamp        the current time
     * @param expiredThreshold the duration between the last update and the moment when the metrics should be removed from the cache
     * @return true if the metrics should be removed from the cache, false otherwise
     */
    public static boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        // Example usage
        long lastUpdateTime = System.currentTimeMillis() - 10000; // 10 seconds ago
        long threshold = 5000; // 5 seconds threshold

        if (isExpired(lastUpdateTime, threshold)) {
            System.out.println("Metrics should be removed from the cache.");
        } else {
            System.out.println("Metrics are still valid.");
        }
    }
}