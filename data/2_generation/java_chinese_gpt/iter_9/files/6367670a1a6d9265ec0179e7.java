import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<Class<?>, Converter> converterMap = new HashMap<>();

    public void registerConverter(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }

    /**
     * 查找并返回指定目标类的任何注册的 {@link Converter}；如果没有注册的 Converter，则返回 <code>null</code>。
     * @param clazz 要返回注册 Converter 的类
     * @return 注册的 {@link Converter}，如果未找到则返回 <code>null</code>
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    public interface Converter {
        // Converter interface methods
    }
}