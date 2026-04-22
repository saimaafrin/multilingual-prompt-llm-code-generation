import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.beans.PropertyDescriptor;

public class BeanMap {
    private Object bean;
    private PropertyDescriptor[] propertyDescriptors;

    /**
     * 返回 BeanMap 的值。
     * @return BeanMap 的值。返回的集合是不可修改的。
     */
    public Collection<Object> values() {
        ArrayList<Object> values = new ArrayList<>();
        
        try {
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                if (descriptor.getReadMethod() != null) {
                    Object value = descriptor.getReadMethod().invoke(bean);
                    values.add(value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get property values", e);
        }

        return Collections.unmodifiableCollection(values);
    }
}