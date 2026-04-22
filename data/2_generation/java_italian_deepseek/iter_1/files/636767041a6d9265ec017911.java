import java.util.HashSet;
import java.util.Set;

public class ObjectRegistry {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> Registra l'oggetto fornito. Utilizzato dai metodi di riflessione per evitare loop infiniti. </p>
     * @param value L'oggetto da registrare.
     */
    public static void register(Object value) {
        if (value != null) {
            registeredObjects.add(value);
        }
    }

    /**
     * Verifica se un oggetto è già stato registrato.
     * @param value L'oggetto da verificare.
     * @return true se l'oggetto è già stato registrato, false altrimenti.
     */
    public static boolean isRegistered(Object value) {
        return registeredObjects.contains(value);
    }

    /**
     * Rimuove un oggetto dal registro.
     * @param value L'oggetto da rimuovere.
     */
    public static void unregister(Object value) {
        registeredObjects.remove(value);
    }

    /**
     * Svuota il registro.
     */
    public static void clearRegistry() {
        registeredObjects.clear();
    }
}