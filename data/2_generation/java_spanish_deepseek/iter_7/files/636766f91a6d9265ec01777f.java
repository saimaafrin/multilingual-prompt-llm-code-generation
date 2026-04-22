public class BooleanUtils {

    /**
     * <p>Convierte un Boolean a un boolean manejando <code>null</code> devolviendo <code>false</code>.</p>
     * <pre>
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false
     * BooleanUtils.toBoolean(null)          = false
     * </pre>
     * @param bool  el booleano a convertir
     * @return <code>true</code> o <code>false</code>, <code>null</code> devuelve <code>false</code>
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // true
        System.out.println(toBoolean(Boolean.FALSE)); // false
        System.out.println(toBoolean(null));         // false
    }
}