/**
 * 判断给定的时间戳是否已经过期。
 * 
 * @param timestamp        当前时间的时间戳
 * @param expiredThreshold 表示最后更新时间与从缓存中移除的时间点之间的持续时间。
 * @return 真值表示该指标应该从缓存中移除。
 */
public boolean isExpired(long timestamp, long expiredThreshold) {
    // 获取当前时间的时间戳
    long currentTime = System.currentTimeMillis();
    
    // 判断当前时间是否超过了时间戳加上过期阈值
    return currentTime > (timestamp + expiredThreshold);
}