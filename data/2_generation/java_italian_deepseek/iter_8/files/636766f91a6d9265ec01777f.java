public class BooleanUtils {

    /**
     * Converte un Boolean in un boolean gestendo null restituendo false.
     * <pre>
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false
     * BooleanUtils.toBoolean(null)          = false
     * </pre>
     * @param bool il boolean da convertire
     * @return true o false, null restituisce false
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    // Esempio di utilizzo
    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // true
        System.out.println(toBoolean(Boolean.FALSE)); // false
        System.out.println(toBoolean(null));          // false
    }
}