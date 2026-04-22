import java.util.Objects;

public class Cache {

    private METRICS existingData;

    public Cache(METRICS initialData) {
        this.existingData = initialData;
    }

    /**
     * Accetta i dati nella cache e li unisce con il valore esistente. Questo metodo non è thread-safe, si dovrebbe evitare di chiamarlo in concorrenza.
     * @param data da aggiungere potenzialmente.
     */
    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Data cannot be null");
        if (existingData == null) {
            existingData = data;
        } else {
            existingData.merge(data);
        }
    }

    public METRICS getExistingData() {
        return existingData;
    }
}

class METRICS {
    private int value;

    public METRICS(int value) {
        this.value = value;
    }

    public void merge(METRICS other) {
        this.value += other.value;
    }

    public int getValue() {
        return value;
    }
}