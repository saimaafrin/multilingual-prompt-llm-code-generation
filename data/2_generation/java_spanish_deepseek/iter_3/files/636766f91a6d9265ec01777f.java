public class BooleanUtils {

    /**
     * Convierte un Boolean a un boolean manejando null devolviendo false.
     * Ejemplos:
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false
     * BooleanUtils.toBoolean(null)          = false
     *
     * @param bool el booleano a convertir
     * @return true o false, null devuelve false
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // true
        System.out.println(toBoolean(Boolean.FALSE)); // false
        System.out.println(toBoolean(null));          // false
    }
}