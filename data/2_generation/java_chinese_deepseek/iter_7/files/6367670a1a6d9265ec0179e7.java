import java.util.HashMap;
import java.util.Map;

public class ConverterLookup {

    private final Map<Class<?>, Converter> converterMap;

    public ConverterLookup() {
        this.converterMap = new HashMap<>();
    }

    /**
     * 查找并返回指定目标类的任何注册的 {@link Converter}；如果没有注册的 Converter，则返回 <code>null</code>。
     * @param clazz 要返回注册 Converter 的类
     * @return 注册的 {@link Converter}，如果未找到则返回 <code>null</code>
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    /**
     * 注册一个 Converter 到指定的类。
     * @param clazz 要注册 Converter 的类
     * @param converter 要注册的 Converter
     */
    public void registerConverter(final Class<?> clazz, final Converter converter) {
        converterMap.put(clazz, converter);
    }

    // Example Converter interface
    public interface Converter {
        Object convert(Object input);
    }
}