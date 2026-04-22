import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties = new HashMap<>();

    public void putAllWriteable(BeanMap map) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(map.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd : propertyDescriptors) {
                if (pd.getWriteMethod() != null && pd.getReadMethod() != null) {
                    Method readMethod = pd.getReadMethod();
                    Object value = readMethod.invoke(map);
                    this.properties.put(pd.getName(), value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public Object get(String key) {
        return properties.get(key);
    }

    // Other methods for BeanMap implementation...
}