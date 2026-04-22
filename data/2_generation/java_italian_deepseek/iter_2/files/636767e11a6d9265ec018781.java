import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, Double> cache = new HashMap<>();

    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final Map<String, Double> data) {
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            cache.merge(key, value, Double::sum);
        }
    }

    // Optional: Getter for the cache to inspect the results
    public Map<String, Double> getCache() {
        return new HashMap<>(cache);
    }
}