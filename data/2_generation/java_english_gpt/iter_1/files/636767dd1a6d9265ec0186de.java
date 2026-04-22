public class CacheManager {
    
    /** 
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager();
        long timestamp = System.currentTimeMillis() - 5000; // 5 seconds ago
        long expiredThreshold = 3000; // 3 seconds

        boolean result = cacheManager.isExpired(timestamp, expiredThreshold);
        System.out.println("Is expired: " + result); // Should print true
    }
}