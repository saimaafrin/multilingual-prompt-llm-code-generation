import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterRegistry {
    
    // Map to store registered converters
    private final Map<Class<?>, Converter> converters = new ConcurrentHashMap<>();
    
    /**
     * Busca y devuelve cualquier {@link Converter} registrado para la clase de destino especificada; 
     * si no hay un Converter registrado, devuelve <code>null</code>.
     * @param clazz Clase para la cual se debe devolver un Converter registrado
     * @return El {@link Converter} registrado o <code>null</code> si no se encuentra
     */
    public Converter lookup(final Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        return converters.get(clazz);
    }
    
    // Interface for type conversion
    public interface Converter {
        Object convert(Object value);
    }
}