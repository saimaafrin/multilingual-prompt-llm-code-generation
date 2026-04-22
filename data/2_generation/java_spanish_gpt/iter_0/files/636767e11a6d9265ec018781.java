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
            combineMetrics(existingData, data);
        }
    }

    private void combineMetrics(METRICS existing, METRICS newData) {
        // Implementar la lógica para combinar existing con newData
        // Esto es un ejemplo, la implementación real dependerá de la estructura de METRICS
        existing.merge(newData);
    }
}