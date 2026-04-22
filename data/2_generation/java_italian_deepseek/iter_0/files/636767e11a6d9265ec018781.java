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
        if (data == null) {
            return;
        }

        String key = data.getKey(); // Assuming METRICS has a method getKey() to retrieve a unique identifier
        METRICS existingData = cache.get(key);

        if (existingData == null) {
            cache.put(key, data);
        } else {
            // Merge the existing data with the new data
            existingData.merge(data); // Assuming METRICS has a method merge(METRICS) to combine data
        }
    }

    // Assuming METRICS is a class with necessary methods
    public static class METRICS {
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
            if (other != null && other.metricsData != null) {
                for (Map.Entry<String, Object> entry : other.metricsData.entrySet()) {
                    this.metricsData.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}