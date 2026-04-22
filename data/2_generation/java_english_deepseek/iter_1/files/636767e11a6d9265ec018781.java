import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, METRICS> cacheMap = new HashMap<>();

    /**
     * Accept the data into the cache and merge with the existing value. This method is not thread safe, should avoid concurrency calling.
     * @param data to be added potentially.
     */
    @Override
    public void accept(final METRICS data) {
        String key = data.getKey(); // Assuming METRICS has a method getKey() to retrieve a unique identifier
        if (cacheMap.containsKey(key)) {
            METRICS existingData = cacheMap.get(key);
            existingData.merge(data); // Assuming METRICS has a method merge(METRICS other) to merge data
        } else {
            cacheMap.put(key, data);
        }
    }
}

// Assuming METRICS class has the following structure
class METRICS {
    private String key;
    // Other fields and methods

    public String getKey() {
        return key;
    }

    public void merge(METRICS other) {
        // Implementation to merge this METRICS with the other METRICS
    }
}