public class ArrayUtil {

    private static final Double[] EMPTY_ARRAY = new Double[0];

    /** 
     * <p>Defensive programming technique to change a <code>null</code> reference to an empty one.</p> 
     * <p>This method returns an empty array for a <code>null</code> input array.</p> 
     * <p>As a memory optimizing technique an empty array passed in will be overridden with the empty <code>public static</code> references in this class.</p>
     * @param array  the array to check for <code>null</code> or empty
     * @return the same array, <code>public static</code> empty array if <code>null</code> or empty input
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Double[] nullArray = null;
        Double[] emptyArray = new Double[0];
        Double[] nonEmptyArray = {1.0, 2.0, 3.0};

        System.out.println(nullToEmpty(nullArray).length); // Output: 0
        System.out.println(nullToEmpty(emptyArray).length); // Output: 0
        System.out.println(nullToEmpty(nonEmptyArray).length); // Output: 3
    }
}