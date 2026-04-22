import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    
    private final Map<Class<?>, Converter> converters = new HashMap<>();
    
    /**
     * Cerca e restituisce qualsiasi {@link Converter} registrato per la classe di destinazione specificata; 
     * se non esiste un Converter registrato, restituisce <code>null</code>.
     * @param clazz Classe per la quale restituire un Converter registrato
     * @return Il {@link Converter} registrato o <code>null</code> se non trovato
     */
    public Converter lookup(final Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        
        return converters.get(clazz);
    }
}

interface Converter {
    Object convert(Object source);
}