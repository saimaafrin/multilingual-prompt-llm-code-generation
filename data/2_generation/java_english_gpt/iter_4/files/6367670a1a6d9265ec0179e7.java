import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<Class<?>, Converter> converterMap = new HashMap<>();

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