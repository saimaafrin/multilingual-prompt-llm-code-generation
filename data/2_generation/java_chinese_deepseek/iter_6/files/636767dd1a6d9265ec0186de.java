/**
 * 判断给定的时间戳是否已经过期。
 * 
 * @param timestamp        当前时间的时间戳
 * @param expiredThreshold 表示最后更新时间与从缓存中移除的时间点之间的持续时间。
 * @return 真值表示该指标应该从缓存中移除。
 */
public boolean isExpired(long timestamp, long expiredThreshold) {
    long currentTime = System.currentTimeMillis();
    return (currentTime - timestamp) > expiredThreshold;
}