import java.util.Objects;

public class MetricsHandler {

    private METRICS existingData;

    /** 
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override 
    public void accept(final METRICS data) {
        if (data != null) {
            if (existingData == null) {
                existingData = data;
            } else {
                mergeMetrics(existingData, data);
            }
        }
    }

    private void mergeMetrics(METRICS existing, METRICS newData) {
        // Implementa la logica di unione dei dati esistenti con i nuovi dati
        // Questo è un esempio generico, la logica specifica dipenderà dalla struttura di METRICS
        existing.combine(newData);
    }
}

class METRICS {
    // Supponiamo che METRICS abbia un metodo combine per unire i dati
    public void combine(METRICS other) {
        // Logica per unire i dati
    }
}