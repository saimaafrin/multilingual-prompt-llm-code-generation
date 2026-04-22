import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanMap {
    private Object bean;

    public BeanMap(Object bean) {
        this.bean = bean;
    }

    public void putAllWriteable(BeanMap map) {
        if (map == null || map.bean == null) {
            return;
        }

        try {
            PropertyDescriptor[] descriptors = java.beans.Introspector.getBeanInfo(map.bean.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                Method readMethod = descriptor.getReadMethod();
                Method writeMethod = descriptor.getWriteMethod();

                // Check if the property is writable and readable
                if (readMethod != null && writeMethod != null) {
                    Object value = readMethod.invoke(map.bean);
                    writeMethod.invoke(this.bean, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to copy properties", e);
        }
    }
}