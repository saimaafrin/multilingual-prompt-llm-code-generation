import java.time.Instant;

public class MetricsCache {
    private long lastUpdateTime;

    /**
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        if (timestamp < 0 || expiredThreshold < 0) {
            throw new IllegalArgumentException("Timestamp and threshold must be non-negative");
        }
        
        long timeDifference = timestamp - lastUpdateTime;
        return timeDifference >= expiredThreshold;
    }
}