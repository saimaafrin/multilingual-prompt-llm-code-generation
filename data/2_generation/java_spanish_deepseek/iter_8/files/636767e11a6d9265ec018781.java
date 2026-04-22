import java.util.Objects;

public class Cache {

    private METRICS existingData;

    /**
     * Acepta los datos en la caché y los combina con el valor existente. Este método no es seguro para hilos, se debe evitar la llamada concurrente.
     * @param data que se va a agregar potencialmente.
     */
    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Data no puede ser nulo");

        if (existingData == null) {
            existingData = data;
        } else {
            // Aquí se combinan los datos existentes con los nuevos
            existingData = combineMetrics(existingData, data);
        }
    }

    private METRICS combineMetrics(METRICS existing, METRICS newData) {
        // Implementación de la lógica para combinar los datos
        // Por ejemplo, sumar valores o concatenar información
        // Este es un ejemplo genérico, ajusta según la implementación de METRICS
        return existing.combine(newData);
    }

    // Clase de ejemplo METRICS (debes definirla según tus necesidades)
    public static class METRICS {
        private int value;

        public METRICS(int value) {
            this.value = value;
        }

        public METRICS combine(METRICS other) {
            return new METRICS(this.value + other.value);
        }

        @Override
        public String toString() {
            return "METRICS{value=" + value + "}";
        }
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.accept(new METRICS(10));
        cache.accept(new METRICS(20));
        System.out.println(cache.existingData); // Debería imprimir METRICS{value=30}
    }
}