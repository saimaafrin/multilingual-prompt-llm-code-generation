public class ArrayUtils {

    /**
     * Clones an array returning a typecast result and handling null.
     * This method returns null for a null input array.
     *
     * @param array the array to clone, may be null
     * @return the cloned array, null if null input
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        System.out.println(java.util.Arrays.toString(cloned)); // Output: [a, b, c]

        char[] nullArray = null;
        char[] clonedNull = clone(nullArray);
        System.out.println(clonedNull); // Output: null
    }
}