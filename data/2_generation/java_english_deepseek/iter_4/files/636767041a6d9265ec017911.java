import java.util.HashSet;
import java.util.Set;

public class ReflectionUtils {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> Registers the given object. Used by the reflection methods to avoid infinite loops. </p>
     * @param value The object to register.
     */
    public static void register(Object value) {
        if (value != null) {
            registeredObjects.add(value);
        }
    }

    public static boolean isRegistered(Object value) {
        return registeredObjects.contains(value);
    }

    public static void clearRegistry() {
        registeredObjects.clear();
    }
}