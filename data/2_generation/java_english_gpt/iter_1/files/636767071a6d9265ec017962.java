import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties = new HashMap<>();

    /**
     * Puts all of the writable properties from the given BeanMap into this BeanMap. Read-only and Write-only properties will be ignored.
     * @param map  the BeanMap whose properties to put
     */
    public void putAllWriteable(BeanMap map) {
        for (String propertyName : map.properties.keySet()) {
            try {
                PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, map.getClass());
                if (descriptor.getWriteMethod() != null) {
                    this.properties.put(propertyName, map.properties.get(propertyName));
                }
            } catch (Exception e) {
                // Ignore if property descriptor cannot be created
            }
        }
    }
}