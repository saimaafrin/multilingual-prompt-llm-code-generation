import java.util.HashSet;
import java.util.Set;

public class Registrar {
    private static final Set<Object> registeredObjects = new HashSet<>();

    /**
     * <p> Registra el objeto dado. Utilizado por los métodos de reflexión para evitar bucles infinitos. </p>
     * @param value El objeto a registrar.
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