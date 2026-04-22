public class CacheUtil {

    /**
     * 判断给定的时间戳是否已经过期。
     * 
     * @param timestamp        当前时间的时间戳
     * @param expiredThreshold 表示最后更新时间与从缓存中移除的时间点之间的持续时间。
     * @return 真值表示该指标应该从缓存中移除。
     */
    public static boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        // 示例用法
        long timestamp = System.currentTimeMillis() - 10000; // 10秒前的时间戳
        long expiredThreshold = 5000; // 5秒的过期阈值
        boolean expired = isExpired(timestamp, expiredThreshold);
        System.out.println("是否过期: " + expired); // 输出: 是否过期: true
    }
}