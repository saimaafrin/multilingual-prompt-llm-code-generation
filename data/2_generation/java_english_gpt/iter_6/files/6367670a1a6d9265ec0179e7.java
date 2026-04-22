import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private Map<Class<?>, Converter> converterMap = new HashMap<>();

    /**
     * Look up and return any registered {@link Converter} for the specified destination class; 
     * if there is no registered Converter, return <code>null</code>.
     * @param clazz Class for which to return a registered Converter
     * @return The registered {@link Converter} or <code>null</code> if not found
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    public void registerConverter(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }

    public interface Converter {
        // Converter interface methods
    }
}