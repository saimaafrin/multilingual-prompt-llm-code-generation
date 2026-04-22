import java.time.Duration;
import java.time.Instant;

public class MetricsCache {
    
    /**
     * @param timestamp        of current time
     * @param expiredThreshold represents the duration between last update time and the time point removing from cache.
     * @return true means this metrics should be removed from cache.
     */
    public boolean isExpired(Instant timestamp, Duration expiredThreshold) {
        if (timestamp == null || expiredThreshold == null) {
            return true;
        }
        
        Instant now = Instant.now();
        Duration timeSinceLastUpdate = Duration.between(timestamp, now);
        
        return timeSinceLastUpdate.compareTo(expiredThreshold) > 0;
    }
}