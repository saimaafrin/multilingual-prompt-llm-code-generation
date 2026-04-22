import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<Class<?>, Converter> converterMap;

    public ConverterRegistry() {
        this.converterMap = new HashMap<>();
    }

    /**
     * Look up and return any registered {@link Converter} for the specified destination class; 
     * if there is no registered Converter, return <code>null</code>.
     * @param clazz Class for which to return a registered Converter
     * @return The registered {@link Converter} or <code>null</code> if not found
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    /**
     * Register a {@link Converter} for the specified class.
     * @param clazz The class for which the converter is registered
     * @param converter The converter to register
     */
    public void register(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }

    // Example Converter interface
    public interface Converter {
        Object convert(Object source);
    }
}