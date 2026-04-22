import java.util.Arrays;

public class ArrayUtils {

    /** 
     * Returns a new array of Strings without null elements. Internal method used to normalize exclude lists (arrays and collections). Note that  {@link Arrays#sort(Object[])} will throw an {@link NullPointerException}if an array element is <code>null</code>.
     * @param array The array to check
     * @return The given array or a new array without null.
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }
        
        return Arrays.stream(array)
                     .filter(obj -> obj != null)
                     .map(Object::toString)
                     .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Object[] inputArray = { "Hello", null, "World", null, "!" };
        String[] resultArray = toNoNullStringArray(inputArray);
        System.out.println(Arrays.toString(resultArray)); // Output: [Hello, World, !]
    }
}