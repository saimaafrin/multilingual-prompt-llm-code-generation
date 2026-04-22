public class CacheExpiration {

    /** 
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        return timestamp > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheExpiration cacheExpiration = new CacheExpiration();
        long currentTime = System.currentTimeMillis();
        long threshold = 10000; // 10 seconds

        // Example usage
        boolean expired = cacheExpiration.isExpired(currentTime - 15000, threshold);
        System.out.println("Is expired: " + expired); // Should print true
    }
}