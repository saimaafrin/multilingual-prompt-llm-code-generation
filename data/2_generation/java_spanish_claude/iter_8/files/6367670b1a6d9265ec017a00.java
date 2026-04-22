public class ArrayUtils {
    /**
     * <p>Verifica si dos arreglos tienen la misma longitud, tratando los arreglos <code>null</code> como longitud <code>0</code>.</p>
     * @param array1 el primer arreglo, puede ser <code>null</code>
     * @param array2 el segundo arreglo, puede ser <code>null</code>
     * @return <code>true</code> si la longitud de los arreglos coincide, tratando <code>null</code> como un arreglo vacío
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null) {
            return array2.length == 0;
        }
        if (array2 == null) {
            return array1.length == 0;
        }
        return array1.length == array2.length;
    }
}