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
            if (map.isWriteable(key)) {
                this.put(key, map.get(key));
            }
        }
    }

    // Assuming this class has a BeanMap instance and a put method
    private BeanMap beanMap;

    public BeanMapUtils(BeanMap beanMap) {
        this.beanMap = beanMap;
    }

    public void put(Object key, Object value) {
        beanMap.put(key, value);
    }
}