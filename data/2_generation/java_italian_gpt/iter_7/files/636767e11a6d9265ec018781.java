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
                // Assuming METRICS has a method to merge data
                existingData.merge(data);
            }
        }
    }

    // Assuming a METRICS class exists with a merge method
    public static class METRICS {
        // Example fields
        private int value;

        public METRICS(int value) {
            this.value = value;
        }

        public void merge(METRICS other) {
            this.value += other.value; // Example merge logic
        }

        // Getters and setters can be added as needed
    }
}