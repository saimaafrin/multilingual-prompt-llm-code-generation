import java.util.HashMap;
import java.util.Map;

public class ConverterLookup {

    private final Map<Class<?>, Converter> converterMap;

    public ConverterLookup() {
        this.converterMap = new HashMap<>();
    }

    /**
     * Cerca e restituisce qualsiasi {@link Converter} registrato per la classe di destinazione specificata; se non esiste un Converter registrato, restituisce <code>null</code>.
     * @param clazz Classe per la quale restituire un Converter registrato
     * @return Il {@link Converter} registrato o <code>null</code> se non trovato
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    /**
     * Registra un Converter per una specifica classe.
     * @param clazz La classe per cui registrare il Converter
     * @param converter Il Converter da registrare
     */
    public void registerConverter(final Class<?> clazz, final Converter converter) {
        converterMap.put(clazz, converter);
    }

    public interface Converter {
        // Metodi del Converter
    }
}