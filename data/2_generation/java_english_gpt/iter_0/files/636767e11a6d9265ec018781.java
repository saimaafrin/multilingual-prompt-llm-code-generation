import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, METRICS> cache = new HashMap<>();

    /** 
     * Accept the data into the cache and merge with the existing value. This method is not thread safe, should avoid concurrency calling.
     * @param data to be added potentially.
     */
    @Override 
    public void accept(final METRICS data) {
        if (data != null) {
            String key = data.getKey(); // Assuming METRICS has a method getKey()
            cache.merge(key, data, (existingValue, newValue) -> {
                existingValue.merge(newValue); // Assuming METRICS has a merge method
                return existingValue;
            });
        }
    }
    
    // Assuming METRICS class is defined somewhere
    public static class METRICS {
        private String key;
        // Other fields...

        public String getKey() {
            return key;
        }

        public void merge(METRICS other) {
            // Logic to merge this METRICS with another METRICS
        }
    }
}