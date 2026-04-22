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
        if (data == null) {
            return;
        }

        String key = data.getKey(); // Assuming METRICS has a method getKey() to retrieve a unique identifier
        METRICS existingData = cacheMap.get(key);

        if (existingData == null) {
            cacheMap.put(key, data);
        } else {
            // Merge logic here, assuming METRICS has a method merge() to combine data
            existingData.merge(data);
            cacheMap.put(key, existingData);
        }
    }
}

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