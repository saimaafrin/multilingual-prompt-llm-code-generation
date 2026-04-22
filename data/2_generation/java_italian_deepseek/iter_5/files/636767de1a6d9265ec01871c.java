import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * Accumula il valore con il valore esistente nella stessa chiave fornita.
     * Se la chiave non esiste, viene creata una nuova entry con il valore fornito.
     * Se la chiave esiste, il valore viene sommato al valore esistente.
     *
     * @param key   La chiave per cui accumulare il valore.
     * @param value Il valore da accumulare.
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    // Metodo per ottenere il valore associato a una chiave (opzionale)
    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    // Metodo per stampare tutte le coppie chiave-valore (opzionale)
    public void printAll() {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}