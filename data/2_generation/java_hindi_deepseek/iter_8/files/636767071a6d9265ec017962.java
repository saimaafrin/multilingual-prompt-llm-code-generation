import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
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
            BeanInfo beanInfo = Introspector.getBeanInfo(map.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd : propertyDescriptors) {
                Method readMethod = pd.getReadMethod();
                Method writeMethod = pd.getWriteMethod();

                if (writeMethod != null && readMethod != null) {
                    String propertyName = pd.getName();
                    Object value = readMethod.invoke(map);
                    this.properties.put(propertyName, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object get(String key) {
        return properties.get(key);
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }
}