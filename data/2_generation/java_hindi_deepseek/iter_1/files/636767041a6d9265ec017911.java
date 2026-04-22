import java.util.HashSet;
import java.util.Set;

public class ObjectRegistry {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> दिए गए ऑब्जेक्ट को रजिस्टर करता है। अनंत लूप से बचने के लिए रिफ्लेक्शन विधियों द्वारा उपयोग किया जाता है। </p>
     * @param value रजिस्टर करने के लिए ऑब्जेक्ट।
     */
    public static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (!registeredObjects.contains(value)) {
            registeredObjects.add(value);
        } else {
            throw new IllegalStateException("Object is already registered");
        }
    }

    public static boolean isRegistered(Object value) {
        return registeredObjects.contains(value);
    }

    public static void unregister(Object value) {
        registeredObjects.remove(value);
    }
}