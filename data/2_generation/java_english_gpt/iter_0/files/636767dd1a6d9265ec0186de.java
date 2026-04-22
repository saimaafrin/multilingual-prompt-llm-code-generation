public class CacheExpiration {

    /** 
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        // Assuming the last update time is represented by the timestamp
        // If the current time minus the last update time exceeds the expired threshold, return true
        return (System.currentTimeMillis() - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheExpiration cacheExpiration = new CacheExpiration();
        long currentTime = System.currentTimeMillis();
        long expiredThreshold = 5000; // 5 seconds
        long lastUpdateTime = currentTime - 6000; // 6 seconds ago

        boolean result = cacheExpiration.isExpired(lastUpdateTime, expiredThreshold);
        System.out.println("Is expired: " + result); // Should print true
    }
}