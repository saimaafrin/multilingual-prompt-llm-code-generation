import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
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
                if (pd.getWriteMethod() != null && pd.getReadMethod() != null) {
                    Object value = pd.getReadMethod().invoke(map);
                    this.properties.put(pd.getName(), value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }
}