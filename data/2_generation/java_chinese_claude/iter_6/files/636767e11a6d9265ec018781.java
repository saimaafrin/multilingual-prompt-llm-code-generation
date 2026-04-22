import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MetricsAcceptor {
    
    private final ConcurrentHashMap<String, METRICS> metricsCache;
    
    public MetricsAcceptor() {
        this.metricsCache = new ConcurrentHashMap<>();
    }
    
    @Override
    public void accept(final METRICS data) {
        // Validate input
        Objects.requireNonNull(data, "Input metrics data cannot be null");
        
        // Get existing metrics for the key if present
        String key = data.getKey();
        METRICS existingMetrics = metricsCache.get(key);
        
        if (existingMetrics == null) {
            // No existing metrics, just put the new data
            metricsCache.put(key, data);
        } else {
            // Merge new data with existing metrics
            existingMetrics.merge(data);
        }
    }
}