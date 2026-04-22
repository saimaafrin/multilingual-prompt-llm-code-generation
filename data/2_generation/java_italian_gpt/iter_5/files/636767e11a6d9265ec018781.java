public class MetricsCache {

    // Assuming METRICS is a class that holds some data
    private METRICS existingData;

    /** 
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override 
    public void accept(final METRICS data) {
        if (existingData == null) {
            existingData = data;
        } else {
            // Assuming METRICS has a method to merge data
            existingData.merge(data);
        }
    }

    // Getter for existingData if needed
    public METRICS getExistingData() {
        return existingData;
    }
}

// Assuming a METRICS class with a merge method
class METRICS {
    // Example fields
    private int value;

    public METRICS(int value) {
        this.value = value;
    }

    public void merge(METRICS other) {
        // Example merge logic
        this.value += other.value;
    }
}