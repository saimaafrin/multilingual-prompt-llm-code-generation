import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterRegistry {
    
    // Map to store registered converters
    private final Map<Class<?>, Converter> converters = new ConcurrentHashMap<>();
    
    /**
     * 查找并返回指定目标类的任何注册的 {@link Converter}；如果没有注册的 Converter，则返回 <code>null</code>。
     * @param clazz 要返回注册 Converter 的类
     * @return 注册的 {@link Converter}，如果未找到则返回 <code>null</code>
     */
    public Converter lookup(final Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        
        // Look for direct match
        Converter converter = converters.get(clazz);
        if (converter != null) {
            return converter;
        }
        
        // Look through class hierarchy
        Class<?> currentClass = clazz;
        while (currentClass != null && currentClass != Object.class) {
            converter = converters.get(currentClass);
            if (converter != null) {
                return converter;
            }
            currentClass = currentClass.getSuperclass();
        }
        
        // Look through interfaces
        for (Class<?> iface : clazz.getInterfaces()) {
            converter = converters.get(iface);
            if (converter != null) {
                return converter;
            }
        }
        
        return null;
    }
}

// Interface for converter implementations
public interface Converter {
    Object convert(Object value);
}