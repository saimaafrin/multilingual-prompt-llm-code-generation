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

        String key = data.getKey(); // Assuming METRICS has a getKey() method
        METRICS existingData = cache.get(key);

        if (existingData == null) {
            cache.put(key, data);
        } else {
            // Merge the existing data with the new data
            existingData.merge(data); // Assuming METRICS has a merge() method
        }
    }
}

// Assuming METRICS class has the following methods:
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