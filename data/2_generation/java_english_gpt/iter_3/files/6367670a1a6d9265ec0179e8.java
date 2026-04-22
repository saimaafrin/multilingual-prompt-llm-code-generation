public class ArrayUtil {

    private static final Boolean[] EMPTY_BOOLEAN_ARRAY = new Boolean[0];

    /** 
     * <p>Defensive programming technique to change a <code>null</code> reference to an empty one.</p> 
     * <p>This method returns an empty array for a <code>null</code> input array.</p> 
     * <p>As a memory optimizing technique an empty array passed in will be overridden with the empty <code>public static</code> references in this class.</p>
     * @param array  the array to check for <code>null</code> or empty
     * @return the same array, <code>public static</code> empty array if <code>null</code> or empty input
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        return (array == null || array.length == 0) ? EMPTY_BOOLEAN_ARRAY : array;
    }

    public static void main(String[] args) {
        Boolean[] testArray1 = null;
        Boolean[] testArray2 = new Boolean[0];
        Boolean[] testArray3 = {true, false};

        System.out.println(nullToEmpty(testArray1).length); // Output: 0
        System.out.println(nullToEmpty(testArray2).length); // Output: 0
        System.out.println(nullToEmpty(testArray3).length); // Output: 2
    }
}