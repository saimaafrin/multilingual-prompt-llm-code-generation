public class ArrayUtils {
    
    /** 
     * <p>Controlla se un array di double primitivi è vuoto o <code>null</code>.</p>
     * @param array  l'array da testare
     * @return <code>true</code> se l'array è vuoto o <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

    public static void main(String[] args) {
        // Test cases
        double[] array1 = null;
        double[] array2 = {};
        double[] array3 = {1.0, 2.0, 3.0};

        System.out.println(isEmpty(array1)); // true
        System.out.println(isEmpty(array2)); // true
        System.out.println(isEmpty(array3)); // false
    }
}