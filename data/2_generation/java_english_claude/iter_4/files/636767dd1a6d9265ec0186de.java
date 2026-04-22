import java.time.Instant;

public class MetricsCache {
    /**
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = Instant.now().toEpochMilli();
        return (currentTime - timestamp) > expiredThreshold;
    }
}