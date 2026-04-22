import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private Map<Class<?>, Converter> converterMap = new HashMap<>();

    /**
     * निर्दिष्ट गंतव्य वर्ग के लिए किसी भी पंजीकृत {@link Converter} को देखें और उसे लौटाएं; यदि कोई पंजीकृत Converter नहीं है, तो <code>null</code> लौटाएं।
     * @param clazz वह वर्ग जिसके लिए पंजीकृत Converter लौटाना है
     * @return पंजीकृत {@link Converter} या यदि नहीं मिला तो <code>null</code>
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