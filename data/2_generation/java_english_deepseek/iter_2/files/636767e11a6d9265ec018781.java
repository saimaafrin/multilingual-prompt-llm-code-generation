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

// Assuming METRICS class has the following structure:
class METRICS {
    private String key;
    private int value;

    public METRICS(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void merge(METRICS other) {
        this.value += other.getValue();
    }
}