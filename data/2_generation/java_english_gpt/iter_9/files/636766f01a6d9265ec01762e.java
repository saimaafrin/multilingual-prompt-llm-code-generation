public class ArrayUtils {

    /** 
     * <p>Checks if an array of primitive doubles is empty or <code>null</code>.</p>
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

    public static void main(String[] args) {
        // Test cases
        double[] nullArray = null;
        double[] emptyArray = {};
        double[] nonEmptyArray = {1.0, 2.0, 3.0};

        System.out.println(isEmpty(nullArray)); // true
        System.out.println(isEmpty(emptyArray)); // true
        System.out.println(isEmpty(nonEmptyArray)); // false
    }
}