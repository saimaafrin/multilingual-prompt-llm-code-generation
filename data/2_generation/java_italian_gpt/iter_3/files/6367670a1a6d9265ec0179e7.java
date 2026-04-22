import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private Map<Class<?>, Converter> converterMap = new HashMap<>();

    public void registerConverter(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }

    /** 
     * Cerca e restituisce qualsiasi {@link Converter} registrato per la classe di destinazione specificata; se non esiste un Converter registrato, restituisce <code>null</code>.
     * @param clazz Classe per la quale restituire un Converter registrato
     * @return Il {@link Converter} registrato o <code>null</code> se non trovato
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }
}

interface Converter {
    // Define methods for the Converter interface
}