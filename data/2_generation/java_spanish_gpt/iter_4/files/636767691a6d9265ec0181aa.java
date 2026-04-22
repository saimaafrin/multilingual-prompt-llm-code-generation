public class HashCodeUtil {
    
    /** 
     * Devuelve un código hash basado en el contenido del array especificado. Si el <code>array</code> es <code>null</code>, este método devuelve 0.
     * @param array el array de tipo long para obtener un código hash
     * @return el código hash del array de tipo long, que podría ser 0 si el array es null.
     */
    public static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        int result = 1;
        for (long element : array) {
            result = 31 * result + Long.hashCode(element);
        }
        return result;
    }

    public static void main(String[] args) {
        long[] array1 = {1L, 2L, 3L};
        long[] array2 = null;

        System.out.println(nullSafeHashCode(array1)); // Example usage
        System.out.println(nullSafeHashCode(array2)); // Example usage
    }
}