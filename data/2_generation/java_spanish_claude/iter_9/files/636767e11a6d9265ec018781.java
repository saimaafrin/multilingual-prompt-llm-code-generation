import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class MetricsCache<METRICS> {

    private AtomicReference<METRICS> cache;

    public MetricsCache() {
        this.cache = new AtomicReference<>();
    }

    /**
     * Acepta los datos en la caché y los combina con el valor existente. Este método no es seguro para hilos, se debe evitar la llamada concurrente.
     * @param data que se va a agregar potencialmente.
     */
    @Override 
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Data cannot be null");
        
        METRICS currentValue = cache.get();
        if (currentValue == null) {
            cache.set(data);
        } else {
            // Si hay un valor existente, combinar los datos
            try {
                if (currentValue instanceof Mergeable) {
                    ((Mergeable)currentValue).merge(data);
                } else {
                    // Si no es mergeable, simplemente reemplazar
                    cache.set(data);
                }
            } catch (Exception e) {
                // En caso de error al combinar, mantener el valor existente
                // y registrar el error
                System.err.println("Error merging metrics data: " + e.getMessage());
            }
        }
    }
}

// Interfaz opcional para objetos que pueden combinarse
interface Mergeable<T> {
    void merge(T other);
}