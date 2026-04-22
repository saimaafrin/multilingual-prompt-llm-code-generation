public class ArrayUtils {

    /** 
     * <p>Verifica si un arreglo de números decimales primitivos está vacío o es <code>null</code>.</p>
     * @param array  el arreglo a probar
     * @return <code>true</code> si el arreglo está vacío o es <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

    public static void main(String[] args) {
        double[] testArray1 = null;
        double[] testArray2 = {};
        double[] testArray3 = {1.0, 2.0, 3.0};

        System.out.println(isEmpty(testArray1)); // true
        System.out.println(isEmpty(testArray2)); // true
        System.out.println(isEmpty(testArray3)); // false
    }
}