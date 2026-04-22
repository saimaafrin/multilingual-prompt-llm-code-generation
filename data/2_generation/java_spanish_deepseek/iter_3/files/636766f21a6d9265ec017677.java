public class BooleanUtils {

    /**
     * Verifica si un valor Boolean no es true, manejando null al devolver true.
     * <pre>
     * BooleanUtils.isNotTrue(Boolean.TRUE)  = false
     * BooleanUtils.isNotTrue(Boolean.FALSE) = true
     * BooleanUtils.isNotTrue(null)          = true
     * </pre>
     * @param bool el booleano a verificar, null devuelve true
     * @return true si la entrada es null o false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));   // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));          // true
    }
}