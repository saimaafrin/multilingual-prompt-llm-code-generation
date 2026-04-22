import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private Map<String, Object> cacheMap;

    public Cache() {
        this.cacheMap = new ConcurrentHashMap<>();
    }

    /**
     * Accept the data into the cache and merge with the existing value. This method is not thread safe, should avoid concurrency calling.
     * @param data to be added potentially.
     */
    public void acceptData(Map<String, Object> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (cacheMap.containsKey(key)) {
                // If value exists, merge with existing value
                Object existingValue = cacheMap.get(key);
                if (existingValue instanceof Map && value instanceof Map) {
                    // If both are maps, merge them
                    ((Map) existingValue).putAll((Map) value);
                } else {
                    // Otherwise replace with new value
                    cacheMap.put(key, value);
                }
            } else {
                // If key doesn't exist, add new entry
                cacheMap.put(key, value);
            }
        }
    }
}