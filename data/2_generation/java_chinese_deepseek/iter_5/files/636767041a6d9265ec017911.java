import java.util.HashSet;
import java.util.Set;

public class Registry {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> 注册给定的对象。用于反射方法以避免无限循环。 </p>
     * @param value 要注册的对象。
     */
    public static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        registeredObjects.add(value);
    }

    public static boolean isRegistered(Object value) {
        return registeredObjects.contains(value);
    }

    public static void clearRegistry() {
        registeredObjects.clear();
    }
}