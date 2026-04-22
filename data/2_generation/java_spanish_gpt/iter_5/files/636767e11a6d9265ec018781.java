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
            // Combina existingData con data
            existingData.combine(data);
        }
    }

    // Método de ejemplo para la clase METRICS
    public static class METRICS {
        // Atributos de METRICS

        public void combine(METRICS other) {
            // Lógica para combinar dos objetos METRICS
        }
    }
}