import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanMap {

    private Map<String, Object> properties;

    public void putAllWriteable(BeanMap map) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(map.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd : propertyDescriptors) {
                Method readMethod = pd.getReadMethod();
                Method writeMethod = pd.getWriteMethod();

                // Check if the property is writable and readable
                if (readMethod != null && writeMethod != null) {
                    Object value = readMethod.invoke(map);
                    this.properties.put(pd.getName(), value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}