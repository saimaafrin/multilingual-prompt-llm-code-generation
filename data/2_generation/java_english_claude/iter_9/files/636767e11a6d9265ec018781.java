import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MetricsCache<METRICS> {
    
    private ConcurrentHashMap<String, METRICS> cache;
    
    public MetricsCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    /** 
     * Accept the data into the cache and merge with the existing value. This method is not thread safe, should avoid concurrency calling.
     * @param data to be added potentially.
     */
    @Override
    public void accept(final METRICS data) {
        if (Objects.isNull(data)) {
            return;
        }

        String key = data.toString();
        METRICS existingValue = cache.get(key);
        
        if (existingValue == null) {
            cache.put(key, data);
        } else {
            // Merge logic would depend on METRICS type
            // For example if METRICS is a numeric type:
            // cache.put(key, existingValue + data);
            // Or if it's a collection:
            // existingValue.addAll(data);
            // cache.put(key, existingValue);
        }
    }
}