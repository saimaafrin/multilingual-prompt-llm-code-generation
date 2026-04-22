import java.util.HashSet;
import java.util.Set;

public class ObjectRegistry {
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

    /**
     * Verifica si el objeto ya ha sido registrado.
     * @param value El objeto a verificar.
     * @return true si el objeto ya está registrado, false en caso contrario.
     */
    public static boolean isRegistered(Object value) {
        return registeredObjects.contains(value);
    }

    /**
     * Elimina el objeto del registro.
     * @param value El objeto a eliminar.
     */
    public static void unregister(Object value) {
        registeredObjects.remove(value);
    }

    /**
     * Limpia todos los objetos registrados.
     */
    public static void clearRegistry() {
        registeredObjects.clear();
    }
}