import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties;

    public BeanMap() {
        // Initialize properties map
    }

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The provided BeanMap cannot be null.");
        }

        for (Map.Entry<String, Object> entry : map.properties.entrySet()) {
            String propertyName = entry.getKey();
            Object value = entry.getValue();

            try {
                PropertyDescriptor pd = new PropertyDescriptor(propertyName, this.getClass());
                Method writeMethod = pd.getWriteMethod();

                if (writeMethod != null) {
                    writeMethod.invoke(this, value);
                }
            } catch (Exception e) {
                // Ignore properties that are read-only or write-only
                continue;
            }
        }
    }

    // Other methods and properties of BeanMap
}