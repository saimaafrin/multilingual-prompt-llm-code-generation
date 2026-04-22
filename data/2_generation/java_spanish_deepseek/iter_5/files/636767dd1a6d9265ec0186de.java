public class CacheUtil {

    /**
     * Determines if a metric should be removed from the cache based on the current timestamp and the expiration threshold.
     *
     * @param timestamp        the current time in milliseconds.
     * @param expiredThreshold the duration in milliseconds between the last update time and the point in time that the metric should be removed from the cache.
     * @return true if the metric should be removed from the cache, false otherwise.
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
            System.out.println("Metric should be removed from the cache.");
        } else {
            System.out.println("Metric is still valid.");
        }
    }
}