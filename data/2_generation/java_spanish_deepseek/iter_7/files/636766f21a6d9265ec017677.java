public class BooleanUtils {

    /**
     * <p>Verifica si un valor <code>Boolean</code> <i>no</i> es <code>true</code>, manejando <code>null</code> al devolver <code>true</code>.</p> <pre> BooleanUtils.isNotTrue(Boolean.TRUE)  = false BooleanUtils.isNotTrue(Boolean.FALSE) = true BooleanUtils.isNotTrue(null)          = true </pre>
     * @param bool  el booleano a verificar, null devuelve <code>true</code>
     * @return <code>true</code> si la entrada es null o false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));   // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));           // true
    }
}