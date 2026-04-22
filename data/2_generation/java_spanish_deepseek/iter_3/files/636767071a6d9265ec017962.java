import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties;

    public BeanMap(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void putAllWriteable(BeanMap map) {
        try {
            PropertyDescriptor[] descriptors = map.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getWriteMethod() != null && descriptor.getReadMethod() != null) {
                    Method readMethod = descriptor.getReadMethod();
                    Object value = readMethod.invoke(map);
                    this.properties.put(descriptor.getName(), value);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private PropertyDescriptor[] getPropertyDescriptors() {
        // This method should return the PropertyDescriptor array for the BeanMap.
        // Implementation depends on the specific BeanMap implementation.
        // For simplicity, we assume it returns an array of PropertyDescriptor objects.
        return new PropertyDescriptor[0];
    }

    public Object get(String propertyName) {
        return properties.get(propertyName);
    }

    public void put(String propertyName, Object value) {
        properties.put(propertyName, value);
    }
}