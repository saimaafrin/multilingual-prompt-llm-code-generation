import java.time.Instant;

public class CacheMetric {
    private long lastUpdateTime;

    /**
     * @param timestamp        del tiempo actual
     * @param expiredThreshold representa la duración entre el último tiempo de actualización y el punto en el tiempo que se eliminará de la caché.
     * @return true significa que esta métrica debe ser eliminada de la caché.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        if (timestamp < 0 || expiredThreshold < 0) {
            throw new IllegalArgumentException("Timestamp and threshold must be non-negative values");
        }
        
        long timeDifference = timestamp - lastUpdateTime;
        return timeDifference >= expiredThreshold;
    }
}