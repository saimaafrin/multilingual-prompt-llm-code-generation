import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterRegistry {
    // Map to store registered converters
    private final Map<Class<?>, Converter<?>> converters = new ConcurrentHashMap<>();

    /**
     * Look up and return any registered {@link Converter} for the specified destination class; 
     * if there is no registered Converter, return <code>null</code>.
     * @param clazz Class for which to return a registered Converter
     * @return The registered {@link Converter} or <code>null</code> if not found
     */
    @SuppressWarnings("unchecked")
    public <T> Converter<T> lookup(Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        return (Converter<T>) converters.get(clazz);
    }

    // Interface for type conversion
    public interface Converter<T> {
        T convert(Object source);
    }
}