public class CacheExpiration {

    /** 
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        // Assuming the last update time is stored in a variable called lastUpdateTime
        long lastUpdateTime = System.currentTimeMillis(); // This should be replaced with the actual last update time
        return (timestamp - lastUpdateTime) > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheExpiration cacheExpiration = new CacheExpiration();
        long currentTime = System.currentTimeMillis();
        long threshold = 5000; // 5 seconds
        boolean expired = cacheExpiration.isExpired(currentTime, threshold);
        System.out.println("Is expired: " + expired);
    }
}