import java.util.HashSet;
import java.util.Set;

public class Registry {
    // Static set to store registered objects
    private static final Set<Object> registeredObjects = new HashSet<>();
    
    /**
     * <p> 注册给定的对象。用于反射方法以避免无限循环。 </p>
     * @param value 要注册的对象。
     */
    static void register(Object value) {
        if (value != null) {
            registeredObjects.add(value);
        }
    }
}