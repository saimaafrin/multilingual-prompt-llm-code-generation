import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
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

        try {
            PropertyDescriptor[] descriptors = map.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getWriteMethod() != null && descriptor.getReadMethod() != null) {
                    Object value = descriptor.getReadMethod().invoke(map);
                    this.properties.put(descriptor.getName(), value);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to copy properties from the provided BeanMap.", e);
        }
    }

    private PropertyDescriptor[] getPropertyDescriptors() {
        // Implement logic to get property descriptors
        return new PropertyDescriptor[0];
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public void setProperty(String propertyName, Object value) {
        properties.put(propertyName, value);
    }
}