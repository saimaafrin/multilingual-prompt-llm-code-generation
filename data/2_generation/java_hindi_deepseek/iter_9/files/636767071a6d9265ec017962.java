import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtils {

    /**
     * दिए गए BeanMap से सभी लिखने योग्य गुणों को इस BeanMap में डालता है। केवल पढ़ने योग्य और केवल लिखने योग्य गुणों को नजरअंदाज किया जाएगा।
     * @param map  वह BeanMap जिसके गुणों को डालना है
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("BeanMap cannot be null");
        }

        for (Object key : map.keySet()) {
            if (map.isWriteable(key.toString())) {
                this.put(key, map.get(key));
            }
        }
    }

    // Assuming this method is part of a class that extends or contains a BeanMap
    private void put(Object key, Object value) {
        // Implementation of put method to add key-value pair to the BeanMap
        // This is a placeholder and should be implemented based on the actual BeanMap usage
    }
}