import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class MetricsCache<METRICS> {
    
    private Map<String, METRICS> cache;
    private METRICS currentMetrics;

    public MetricsCache() {
        this.cache = new ConcurrentHashMap<>();
        this.currentMetrics = null;
    }

    /**
     * Accept the data into the cache and merge with the existing value. This method is not thread safe, should avoid concurrency calling.
     * @param data to be added potentially.
     */
    @Override
    public void accept(final METRICS data) {
        if (data == null) {
            return;
        }

        if (currentMetrics == null) {
            currentMetrics = data;
        } else {
            try {
                // Merge the new data with existing metrics
                if (data instanceof Map) {
                    ((Map)currentMetrics).putAll((Map)data);
                } else {
                    // For non-map objects, just replace with new data
                    currentMetrics = data;
                }
            } catch (Exception e) {
                // Fallback to simple replacement if merge fails
                currentMetrics = data;
            }
        }

        // Store in cache using timestamp or unique key
        String key = String.valueOf(System.currentTimeMillis());
        cache.put(key, data);
    }
}