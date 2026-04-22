import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class MetricsCache {
    private AtomicReference<METRICS> cache = new AtomicReference<>();
    
    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final METRICS data) {
        if (data == null) {
            return;
        }

        METRICS currentValue = cache.get();
        if (currentValue == null) {
            cache.set(data);
        } else {
            cache.set(currentValue.merge(data));
        }
    }
}