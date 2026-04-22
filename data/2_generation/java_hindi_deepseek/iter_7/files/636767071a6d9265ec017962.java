import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtils {

    /**
     * दिए गए BeanMap से सभी लिखने योग्य गुणों को इस BeanMap में डालता है। केवल पढ़ने योग्य और केवल लिखने योग्य गुणों को नजरअंदाज किया जाएगा।
     * @param map  वह BeanMap जिसके गुणों को डालना है
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("Input BeanMap cannot be null");
        }

        // Iterate over all the properties in the input BeanMap
        for (Object key : map.keySet()) {
            // Check if the property is writable
            if (map.isWriteable(key.toString())) {
                // Get the value from the input BeanMap
                Object value = map.get(key);
                // Put the value into this BeanMap
                this.put(key, value);
            }
        }
    }
}