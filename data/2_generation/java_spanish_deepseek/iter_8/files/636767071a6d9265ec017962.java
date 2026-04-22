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

    public static void main(String[] args) {
        BeanMap source = new BeanMap();
        source.put("name", "John");
        source.put("age", 30);

        BeanMap target = new BeanMap();
        target.putAllWriteable(source);

        System.out.println(target.get("name")); // Output: John
        System.out.println(target.get("age"));  // Output: 30
    }
}