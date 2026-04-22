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
            // Merge logic would depend on METRICS type
            // For demonstration, just overwrite with new value
            cache.set(data);
        }
    }
}