import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {

    private final Map<Class<?>, Converter> registry = new HashMap<>();

    /**
     * Cerca e restituisce qualsiasi {@link Converter} registrato per la classe di destinazione specificata; se non esiste un Converter registrato, restituisce <code>null</code>.
     * @param clazz Classe per la quale restituire un Converter registrato
     * @return Il {@link Converter} registrato o <code>null</code> se non trovato
     */
    public Converter lookup(final Class<?> clazz) {
        return registry.get(clazz);
    }

    /**
     * Registra un {@link Converter} per una specifica classe.
     * @param clazz La classe per cui registrare il Converter
     * @param converter Il Converter da registrare
     */
    public void register(final Class<?> clazz, final Converter converter) {
        registry.put(clazz, converter);
    }

    // Example Converter interface
    public interface Converter {
        Object convert(Object input);
    }
}