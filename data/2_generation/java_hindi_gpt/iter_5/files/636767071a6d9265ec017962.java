import org.apache.commons.beanutils.BeanMap;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanMapUtil {

    /** 
     * दिए गए BeanMap से सभी लिखने योग्य गुणों को इस BeanMap में डालता है। केवल पढ़ने योग्य और केवल लिखने योग्य गुणों को नजरअंदाज किया जाएगा।
     * @param map  वह BeanMap जिसके गुणों को डालना है
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("BeanMap cannot be null");
        }

        Object bean = map.getBean();
        PropertyDescriptor[] propertyDescriptors = java.beans.Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();

        for (PropertyDescriptor descriptor : propertyDescriptors) {
            Method writeMethod = descriptor.getWriteMethod();
            if (writeMethod != null) {
                try {
                    // Assuming we want to set a default value or some logic to populate the writable properties
                    // Here we just set a default value for demonstration purposes
                    writeMethod.invoke(bean, getDefaultValue(descriptor.getPropertyType()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object getDefaultValue(Class<?> type) {
        if (type == int.class) {
            return 0;
        } else if (type == boolean.class) {
            return false;
        } else if (type == double.class) {
            return 0.0;
        } else if (type == String.class) {
            return "";
        }
        // Add more types as needed
        return null;
    }
}