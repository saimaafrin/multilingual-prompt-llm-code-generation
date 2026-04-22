public class CacheUtil {

    /**
     * Determines if the metrics should be removed from the cache based on the given timestamp and expiration threshold.
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
        long timestamp = System.currentTimeMillis() - 10000; // 10 seconds ago
        long expiredThreshold = 5000; // 5 seconds threshold

        boolean shouldRemove = isExpired(timestamp, expiredThreshold);
        System.out.println("Should remove from cache: " + shouldRemove); // Output: Should remove from cache: true
    }
}