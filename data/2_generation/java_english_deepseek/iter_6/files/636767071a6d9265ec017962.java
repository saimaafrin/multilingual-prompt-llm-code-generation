import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties;

    public BeanMap() {
        // Initialize the properties map
        properties = new java.util.HashMap<>();
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

    // Example of a property setter
    public void setProperty(String name, Object value) {
        properties.put(name, value);
    }

    // Example of a property getter
    public Object getProperty(String name) {
        return properties.get(name);
    }
}