import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanMap {
    private Object bean;
    
    public BeanMap(Object bean) {
        this.bean = bean;
    }

    public Collection<Object> values() {
        if (bean == null) {
            return Collections.emptyList();
        }

        ArrayList<Object> values = new ArrayList<>();
        
        try {
            PropertyDescriptor[] descriptors = java.beans.Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
            
            for (PropertyDescriptor descriptor : descriptors) {
                Method readMethod = descriptor.getReadMethod();
                if (readMethod != null && !descriptor.getName().equals("class")) {
                    Object value = readMethod.invoke(bean);
                    values.add(value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get bean values", e);
        }

        return Collections.unmodifiableCollection(values);
    }
}