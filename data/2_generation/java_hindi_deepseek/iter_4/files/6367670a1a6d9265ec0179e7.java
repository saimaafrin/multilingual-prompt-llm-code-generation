import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<Class<?>, Converter> converterMap;

    public ConverterRegistry() {
        this.converterMap = new HashMap<>();
    }

    /**
     * निर्दिष्ट गंतव्य वर्ग के लिए किसी भी पंजीकृत {@link Converter} को देखें और उसे लौटाएं; यदि कोई पंजीकृत Converter नहीं है, तो <code>null</code> लौटाएं।
     * @param clazz वह वर्ग जिसके लिए पंजीकृत Converter लौटाना है
     * @return पंजीकृत {@link Converter} या यदि नहीं मिला तो <code>null</code>
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    /**
     * एक Converter को किसी विशेष वर्ग के लिए पंजीकृत करें।
     * @param clazz वह वर्ग जिसके लिए Converter पंजीकृत करना है
     * @param converter पंजीकृत करने के लिए Converter
     */
    public void registerConverter(final Class<?> clazz, final Converter converter) {
        converterMap.put(clazz, converter);
    }

    public static void main(String[] args) {
        ConverterRegistry registry = new ConverterRegistry();
        // Example usage
        registry.registerConverter(String.class, new StringConverter());
        Converter converter = registry.lookup(String.class);
        if (converter != null) {
            System.out.println("Converter found for String class.");
        } else {
            System.out.println("No converter found for String class.");
        }
    }
}

interface Converter {
    // Converter methods can be defined here
}

class StringConverter implements Converter {
    // Implementation of StringConverter
}