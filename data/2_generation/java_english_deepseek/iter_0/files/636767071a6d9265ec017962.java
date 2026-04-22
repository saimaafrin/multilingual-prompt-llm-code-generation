import java.util.Map;
import java.util.HashMap;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class BeanMap {
    private Map<String, Object> properties = new HashMap<>();

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The provided BeanMap cannot be null.");
        }

        for (Map.Entry<String, Object> entry : map.properties.entrySet()) {
            String propertyName = entry.getKey();
            Object value = entry.getValue();

            try {
                PropertyDescriptor pd = new PropertyDescriptor(propertyName, this.getClass());
                if (pd.getWriteMethod() != null) {
                    pd.getWriteMethod().invoke(this, value);
                }
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                // Ignore properties that cannot be written or do not exist
            }
        }
    }

    // Example of a property setter
    public void setProperty(String propertyName, Object value) {
        properties.put(propertyName, value);
    }

    // Example of a property getter
    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}