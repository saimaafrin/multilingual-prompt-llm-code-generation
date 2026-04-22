import java.util.HashSet;
import java.util.Set;

public class ObjectRegistry {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> दिए गए ऑब्जेक्ट को रजिस्टर करता है। अनंत लूप से बचने के लिए रिफ्लेक्शन विधियों द्वारा उपयोग किया जाता है। </p>
     * @param value रजिस्टर करने के लिए ऑब्जेक्ट।
     */
    static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Null objects cannot be registered.");
        }
        if (!registeredObjects.contains(value)) {
            registeredObjects.add(value);
        } else {
            throw new IllegalStateException("Object is already registered.");
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        register(obj);
        System.out.println("Object registered successfully.");
    }
}