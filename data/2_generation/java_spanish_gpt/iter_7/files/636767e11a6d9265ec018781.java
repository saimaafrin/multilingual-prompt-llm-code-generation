public class MetricsCache {

    private METRICS existingData;

    /** 
     * Acepta los datos en la caché y los combina con el valor existente. Este método no es seguro para hilos, se debe evitar la llamada concurrente.
     * @param data que se va a agregar potencialmente.
     */
    @Override 
    public void accept(final METRICS data) {
        if (existingData == null) {
            existingData = data;
        } else {
            // Combine existingData with new data
            existingData.combine(data);
        }
    }

    // Assuming METRICS class has a combine method
    public static class METRICS {
        // Example fields
        private int value;

        public METRICS(int value) {
            this.value = value;
        }

        public void combine(METRICS other) {
            this.value += other.value; // Example combination logic
        }
    }
}