public class CacheExpiration {

    /** 
     * @param timestamp        当前时间的时间戳
     * @param expiredThreshold 表示最后更新时间与从缓存中移除的时间点之间的持续时间。
     * @return 真值表示该指标应该从缓存中移除。
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheExpiration cacheExpiration = new CacheExpiration();
        long timestamp = System.currentTimeMillis() - 10000; // 10 seconds ago
        long expiredThreshold = 5000; // 5 seconds

        boolean result = cacheExpiration.isExpired(timestamp, expiredThreshold);
        System.out.println("Is expired: " + result); // Should print true
    }
}