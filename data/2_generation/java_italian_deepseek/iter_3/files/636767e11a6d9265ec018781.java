import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, Double> cache = new HashMap<>();

    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final METRICS data) {
        for (Map.Entry<String, Double> entry : data.getMetrics().entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            cache.merge(key, value, Double::sum);
        }
    }

    // Assuming METRICS is a class that contains a map of metrics
    public static class METRICS {
        private Map<String, Double> metrics;

        public METRICS(Map<String, Double> metrics) {
            this.metrics = metrics;
        }

        public Map<String, Double> getMetrics() {
            return metrics;
        }
    }
}