import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class MetricsCache<METRICS> {
    
    private final AtomicReference<METRICS> cache = new AtomicReference<>();

    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Input data cannot be null");
        
        METRICS currentValue = cache.get();
        if (currentValue == null) {
            cache.set(data);
        } else {
            // Since we don't know the exact type of METRICS, we assume it has a merge method
            // In a real implementation, you would need to implement the specific merge logic
            try {
                if (currentValue instanceof Mergeable) {
                    ((Mergeable)currentValue).merge(data);
                } else {
                    // Default behavior is to replace the old value
                    cache.set(data);
                }
            } catch (Exception e) {
                // Fallback to simple replacement if merge fails
                cache.set(data);
            }
        }
    }

    // Interface for mergeable objects
    public interface Mergeable<T> {
        void merge(T other);
    }
}