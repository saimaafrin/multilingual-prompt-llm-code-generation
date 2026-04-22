public class ArrayUtils {

    /**
     * <p>Verifica si dos arreglos tienen la misma longitud, tratando los arreglos <code>null</code> como longitud <code>0</code>.</p>
     * @param array1 el primer arreglo, puede ser <code>null</code>
     * @param array2 el segundo arreglo, puede ser <code>null</code>
     * @return <code>true</code> si la longitud de los arreglos coincide, tratando <code>null</code> como un arreglo vacío
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        byte[] array1 = {1, 2, 3};
        byte[] array2 = {4, 5, 6};
        byte[] array3 = null;
        byte[] array4 = {7, 8};

        System.out.println(isSameLength(array1, array2)); // true
        System.out.println(isSameLength(array1, array3)); // false
        System.out.println(isSameLength(array3, array4)); // false
        System.out.println(isSameLength(array3, array3)); // true
    }
}