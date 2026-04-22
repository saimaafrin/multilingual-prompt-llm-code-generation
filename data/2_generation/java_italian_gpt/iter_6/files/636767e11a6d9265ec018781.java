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
        // Ad esempio, sommare i valori o aggiornare i conteggi
        // existing.setValue(existing.getValue() + newData.getValue());
    }

    // Classe METRICS di esempio
    public static class METRICS {
        private int value;

        public METRICS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}