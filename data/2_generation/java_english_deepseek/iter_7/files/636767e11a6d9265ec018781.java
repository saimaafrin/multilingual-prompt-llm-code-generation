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
        String key = data.getKey(); // Assuming METRICS has a method getKey() to retrieve the unique key
        if (cacheMap.containsKey(key)) {
            METRICS existingData = cacheMap.get(key);
            existingData.merge(data); // Assuming METRICS has a method merge() to merge with another METRICS object
        } else {
            cacheMap.put(key, data);
        }
    }
}

// Assuming METRICS class has the following structure
class METRICS {
    private String key;
    private Map<String, Object> metricsData;

    public METRICS(String key, Map<String, Object> metricsData) {
        this.key = key;
        this.metricsData = metricsData;
    }

    public String getKey() {
        return key;
    }

    public void merge(METRICS other) {
        this.metricsData.putAll(other.metricsData);
    }

    public Map<String, Object> getMetricsData() {
        return metricsData;
    }
}