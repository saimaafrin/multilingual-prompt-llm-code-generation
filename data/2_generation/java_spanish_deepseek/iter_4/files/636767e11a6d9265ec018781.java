import java.util.Objects;

public class Cache {

    private METRICS existingData;

    public Cache(METRICS initialData) {
        this.existingData = initialData;
    }

    /**
     * Acepta los datos en la caché y los combina con el valor existente. Este método no es seguro para hilos, se debe evitar la llamada concurrente.
     * @param data que se va a agregar potencialmente.
     */
    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Data cannot be null");
        if (existingData == null) {
            existingData = data;
        } else {
            // Aquí se combinan los datos existentes con los nuevos datos.
            // Asumiendo que METRICS tiene un método para combinar datos.
            existingData.combine(data);
        }
    }

    public METRICS getExistingData() {
        return existingData;
    }
}

// Asumiendo que la clase METRICS tiene un método combine para combinar datos.
class METRICS {
    private int value;

    public METRICS(int value) {
        this.value = value;
    }

    public void combine(METRICS other) {
        this.value += other.value;
    }

    public int getValue() {
        return value;
    }
}