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
            for (PropertyDescriptor pd : map.getPropertyDescriptors()) {
                if (pd.getWriteMethod() != null && pd.getReadMethod() != null) {
                    Object value = pd.getReadMethod().invoke(map);
                    this.properties.put(pd.getName(), value);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private PropertyDescriptor[] getPropertyDescriptors() {
        // This method should return the PropertyDescriptor array for the BeanMap.
        // For simplicity, we assume it's implemented elsewhere.
        return new PropertyDescriptor[0];
    }

    public Object get(String propertyName) {
        return properties.get(propertyName);
    }

    public void put(String propertyName, Object value) {
        properties.put(propertyName, value);
    }
}