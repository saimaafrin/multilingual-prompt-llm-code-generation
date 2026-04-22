public class CacheUtil {

    /**
     * Determines if the given timestamp has expired based on the provided threshold.
     *
     * @param timestamp        the current time or the time to be checked
     * @param expiredThreshold the duration between the last update and the moment when the item should be removed from the cache
     * @return true if the timestamp has expired and should be removed from the cache, false otherwise
     */
    public static boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        // Example usage
        long timestamp = System.currentTimeMillis() - 10000; // 10 seconds ago
        long expiredThreshold = 5000; // 5 seconds threshold

        if (isExpired(timestamp, expiredThreshold)) {
            System.out.println("The item has expired and should be removed from the cache.");
        } else {
            System.out.println("The item is still valid in the cache.");
        }
    }
}