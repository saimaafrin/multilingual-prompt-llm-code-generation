import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, METRICS> cache = new HashMap<>();

    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final METRICS data) {
        String key = data.getKey(); // Assuming METRICS has a method getKey() to retrieve a unique identifier
        if (cache.containsKey(key)) {
            METRICS existingData = cache.get(key);
            existingData.merge(data); // Assuming METRICS has a method merge() to combine data
        } else {
            cache.put(key, data);
        }
    }
}

// Assuming METRICS class has the following structure:
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

    // Other methods and fields as needed
}